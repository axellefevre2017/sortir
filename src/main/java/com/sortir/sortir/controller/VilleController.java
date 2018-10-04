package com.sortir.sortir.controller;

import com.sortir.sortir.controller.dto.SortieDto;
import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.sortie.SortieAddRoute;
import com.sortir.sortir.controller.route.ville.VilleEditRoute;
import com.sortir.sortir.controller.route.ville.VilleRoute;
import com.sortir.sortir.entity.Sortie;
import com.sortir.sortir.entity.Ville;
import com.sortir.sortir.repository.LieuRepository;
import com.sortir.sortir.repository.ParticipantRepository;
import com.sortir.sortir.repository.VilleRepository;
import com.sortir.sortir.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class VilleController {

    @Autowired
    SortieService sortieService;

    @Autowired
    LieuRepository lieuRepository;

    @Autowired
    VilleRepository villeRepository;


    @Autowired
    ParticipantRepository participantRepository;


    List<String> errors = new ArrayList<>();

    @GetMapping("/ville/")
    public String add(Model model, Principal principal){

        VilleRoute route = new VilleRoute();
        model.addAttribute("route",route);

        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @PostMapping("/ville/")
    public RedirectView addValidation(Principal principal, @RequestParam("ville") String villeParam, @RequestParam("codePostal") String codePostal, Model model, RedirectAttributes ra) throws Exception {

        VilleRoute route = new VilleRoute();
        model.addAttribute("route",route);

        Ville ville = new Ville();
        ville.setCodePostal(codePostal);
        ville.setVille(villeParam);

        if (checkVille(villeParam,codePostal)) {
            villeRepository.save(ville);
        } else {
            ra.addFlashAttribute("errors", errors);
        }

        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return new RedirectView("/ville/");
    }

    @PostMapping("/ville/rechercher/")
    public String search(Principal principal,@RequestParam("ville") String villeParam,Model model){

        VilleRoute route = new VilleRoute();
        model.addAttribute("route",route);
        model.addAttribute("filtre", villeParam);
        model.addAttribute("villes", villeRepository.findAllByVilleContaining(villeParam));
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @GetMapping("/ville/edit/{id}/")
    public String add(Principal principal,@PathVariable Integer id, Model model){

        VilleEditRoute route = new VilleEditRoute();
        model.addAttribute("route",route);

        model.addAttribute("ville", villeRepository.findById(id).get());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @PostMapping("/ville/edit/{id}/")
    public RedirectView editValidation(Principal principal,@PathVariable Integer id,@RequestParam("ville") String villeParam, @RequestParam("codePostal") String codePostal, Model model, RedirectAttributes ra) throws Exception {

        VilleRoute route = new VilleRoute();
        model.addAttribute("route",route);
        Ville ville = villeRepository.getOne(id);
        ville.setVille(villeParam);
        ville.setCodePostal(codePostal);

        if (checkVille(villeParam,codePostal)) {
            villeRepository.save(ville);
        } else {
            ra.addFlashAttribute("errors", errors);
        }


        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return new RedirectView(route.getUrl()+"edit/"+id+"/");
    }

    @GetMapping("/ville/delete/{id}/")
    public RedirectView delete(Principal principal,@PathVariable Integer id, Model model, RedirectAttributes ra) throws Exception {

        VilleRoute route = new VilleRoute();
        model.addAttribute("route",route);

        if (checkIfAttached(villeRepository.getOne(id).getId())) {
            villeRepository.deleteById(id);
        } else {
            ra.addFlashAttribute("errors", errors);
        }

        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        model.addAttribute("villes", villeRepository.findAll());

        return new RedirectView("/ville/");
    }

    public Boolean checkVille(String ville, String codePostal) throws Exception {

        //On vide la liste d'erreur
        errors.removeAll(errors);

        if (ville == null || ville.isEmpty()) {
            errors.add("La ville ne peut pas être vide.");
        }
        if (codePostal == null || codePostal.isEmpty()) {
            errors.add("Le code postal ne peut pas être vide.");
        }

        for(int i=0;i<villeRepository.findAll().size();i++){
            if(villeRepository.findAll().get(i).getVille().toLowerCase().equals(ville.toLowerCase()) && villeRepository.findAll().get(i).getCodePostal().toLowerCase().equals(codePostal.toLowerCase())){
                errors.add("Cette ville ("+ville+") existe déjà avec ce code postal ("+codePostal+").");
            }
        }

        if (!errors.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    public Boolean checkIfAttached(Integer id) throws Exception {

        //On vide la liste d'erreur
        errors.removeAll(errors);

        List<SortieDto> sortieList = sortieService.findAll();

        int compteur = 0;
        int compteur2 = 0;

        for(int i=0;i<sortieList.size();i++){

            if (sortieList.get(i).getLieu().getVille().getId()== id) {
                compteur = compteur+1;
            }
        }
        for(int i=0;i<participantRepository.findAll().size();i++){

            if (participantRepository.findAll().get(i).getVille().getId()== id) {
                compteur2 = compteur2+1;
                System.out.println("compteur2 = "+compteur2);
            }
        }

        if(compteur==1){
            errors.add("Impossible de supprimer cette ville. Elle est liée à " + compteur + " sortie.");
        }
        if(compteur>1){
            errors.add("Impossible de supprimer cette ville. Elle est liée à " + compteur + " sorties.");
        }
        if(compteur2==1){
            errors.add("Impossible de supprimer cette ville. Elle est liée à " + compteur2 + " participant.");
        }
        if(compteur2>1){
            errors.add("Impossible de supprimer cette ville. Elle est liée à " + compteur2 + " participants.");
        }

        if (!errors.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }



}
