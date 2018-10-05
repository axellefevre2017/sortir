package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.ProfilRoute;
import com.sortir.sortir.entity.Participant;
import com.sortir.sortir.repository.LieuRepository;
import com.sortir.sortir.repository.ParticipantRepository;
import com.sortir.sortir.repository.SiteRepository;
import com.sortir.sortir.repository.VilleRepository;
import com.sortir.sortir.service.ParticipantService;
import com.sortir.sortir.service.SortieService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    SortieService sortieService;

    @Autowired
    ParticipantService participantService;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    VilleRepository villeRepository;

    @Autowired
    LieuRepository lieuRepository;


    List<String> errors = new ArrayList<>();

    List<String> success = new ArrayList<>();


    @GetMapping("/")
    public String getHome(Model model, Principal principal) {

        HomeRoute route = new HomeRoute();
        model.addAttribute("route", route);

        model.addAttribute("sites", villeRepository.findAll());
        model.addAttribute("sorties", sortieService.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @PostMapping("/")
    public String filter(Model model, Principal principal,
                         @RequestParam @Nullable Integer site,
                         @RequestParam @Nullable String name_sortie,
                         @RequestParam @Nullable String date_debut,
                         @RequestParam @Nullable String date_fin,
                         @RequestParam @Nullable Boolean organisateur,
                         @RequestParam @Nullable Boolean inscrit,
                         @RequestParam @Nullable Boolean noninscrit,
                         @RequestParam @Nullable Boolean passees) throws ParseException {

        HomeRoute route = new HomeRoute();
        model.addAttribute("route", route);

        model.addAttribute("sites", villeRepository.findAll());
        model.addAttribute("sorties", sortieService.filter(participantRepository.findByPseudo(principal.getName()), site, name_sortie, date_debut, date_fin, organisateur, inscrit, noninscrit, passees));
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @GetMapping("/profil/")
    public String getProfil(Model model, Principal principal) {

        ProfilRoute route = new ProfilRoute();
        model.addAttribute("route", route);

        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @PostMapping("/profil/")
    public RedirectView modifyProfil(Model model, Principal principal,
                               @RequestParam("pseudo") String pseudo,
                               @RequestParam("id") Integer id,
                               @RequestParam("nom") String nom,
                               @RequestParam("prenom") String prenom,
                               @RequestParam("telephone") String telephone,
                               @RequestParam("mail") String mail,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword,
                               @RequestParam("ville") Integer ville, RedirectAttributes ra) throws Exception {

        ProfilRoute route = new ProfilRoute();
        model.addAttribute("route", route);

        if (checkProfil(principal.getName(), pseudo, nom, prenom, telephone, mail, password, confirmPassword)) {
            participantService.save(id, pseudo, nom, prenom, telephone, mail, password, ville);
            majContext(participantRepository.findByPseudo(pseudo), pseudo);
            success.removeAll(success);
            success.add("Profil modifié.");
            ra.addFlashAttribute("success", success);
        } else {
            model.addAttribute("errors", errors);
            ra.addFlashAttribute("errors", errors);
        }

        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return new RedirectView("/profil/");
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

        if (!password.equals(confirmPassword)) {
            errors.add("Les mots de passe saisis ne sont pas identiques.");
        }
        if (participantRepository.findIfExists(pseudo) > 0 && !user.equals(pseudo)) {
            errors.add("Le pseudo " + pseudo + " est déjà utilisé. Veuillez en saisir un autre.");
        } else {
            majContext(participantRepository.findByPseudo(user), pseudo);
        }
        if (pseudo == null || pseudo.isEmpty()) {
            errors.add("Le mot de passe ne peut pas être vide.");
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

    public void majContext(Participant userObject, String newPseudo){

        userObject.setPseudo(newPseudo);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userObject.getPseudo(), userObject.getPassword(), null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


}
