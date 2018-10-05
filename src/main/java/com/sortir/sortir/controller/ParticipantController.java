package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.ParticipantAddRoute;
import com.sortir.sortir.controller.route.ParticipantRoute;
import com.sortir.sortir.repository.InscriptionRepository;
import com.sortir.sortir.repository.ParticipantRepository;
import com.sortir.sortir.repository.SortieRepository;
import com.sortir.sortir.repository.VilleRepository;
import com.sortir.sortir.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ParticipantController {

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    SortieRepository sortieRepository;

    @Autowired
    VilleRepository villeRepository;

    @Autowired
    ParticipantService participantService;


    List<String> success = new ArrayList<>();

    List<String> errors = new ArrayList<>();

    @GetMapping("/participant/")
    public String participant(Model model, Principal principal) {

        ParticipantRoute route = new ParticipantRoute();
        model.addAttribute("route", route);

        model.addAttribute("participants", participantRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @GetMapping("/participant/add/")
    public String participantAdd(Model model, Principal principal) {

        ParticipantAddRoute route = new ParticipantAddRoute();
        model.addAttribute("route", route);
        model.addAttribute("villes",villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @PostMapping("/participant/add/")
    public RedirectView participantValidation(Model model, Principal principal,
                                              @RequestParam("pseudo") String pseudo,
                                              @RequestParam("nom") String nom,
                                              @RequestParam("prenom") String prenom,
                                              @RequestParam("telephone") String telephone,
                                              @RequestParam("mail") String mail,
                                              @RequestParam("password") String password,
                                              @RequestParam("confirmPassword") String confirmPassword,
                                              @RequestParam("ville") Integer ville,
                                              @RequestParam("admin") @Nullable Boolean admin,
                                              @RequestParam("actif") @Nullable Boolean actif,RedirectAttributes ra) throws Exception {

        ParticipantRoute route = new ParticipantRoute();
        model.addAttribute("route", route);

        if (checkProfil(principal.getName(), pseudo, nom, prenom, telephone, mail, password, confirmPassword)) {
            participantService.add(pseudo, nom, prenom, telephone, mail, password, ville, admin, actif);
            success.removeAll(success);
            success.add("Profil modifié.");
            ra.addFlashAttribute("success", success);
        } else {
            model.addAttribute("errors", errors);
            ra.addFlashAttribute("errors", errors);
        }



        model.addAttribute("villes",villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return new RedirectView("/participant/");
    }



    public Boolean checkProfil(String user,
                               String pseudo,
                               String nom,
                               String prenom,
                               String telephone,
                               String mail,
                               String password,
                               String confirmPassword) throws Exception {

        //On vide la liste d'erreur
        errors.removeAll(errors);

        if (password == null || password.isEmpty()) {
            errors.add("Le mot de passe ne peut pas être vide.");
        }
        if (!password.equals(confirmPassword)) {
            errors.add("Les mots de passe saisis ne sont pas identiques.");
        }
        if (participantRepository.findIfExists(pseudo) > 0 && !user.equals(pseudo)) {
            errors.add("Le pseudo " + pseudo + " est déjà utilisé. Veuillez en saisir un autre.");
        }
        if (pseudo == null || pseudo.isEmpty()) {
            errors.add("Le pseudo ne peut pas être vide.");
        }
        if (nom == null || nom.isEmpty()) {
            errors.add("Le nom ne peut pas être vide.");
        }
        if (prenom == null || prenom.isEmpty()) {
            errors.add("Le prénom ne peut pas être vide.");
        }

        if (!errors.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }


}
