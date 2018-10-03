package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.sortie.SortieAddRoute;
import com.sortir.sortir.controller.route.ville.VilleEditRoute;
import com.sortir.sortir.controller.route.ville.VilleRoute;
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
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @GetMapping("/ville/")
    public String add(Model model, Principal principal){

        VilleRoute route = new VilleRoute();
        model.addAttribute("route",route);

        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @PostMapping("/ville/")
    public String addValidation(Principal principal, @RequestParam("ville") String villeParam, @RequestParam("codePostal") String codePostal,Model model){

        VilleRoute route = new VilleRoute();
        model.addAttribute("route",route);

        Ville ville = new Ville();
        ville.setCodePostal(codePostal);
        ville.setVille(villeParam);

        villeRepository.save(ville);

        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
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
    public RedirectView editValidation(Principal principal,@PathVariable Integer id,@RequestParam("ville") String villeParam, @RequestParam("codePostal") String codePostal, Model model){

        VilleRoute route = new VilleRoute();
        model.addAttribute("route",route);
        Ville ville = villeRepository.getOne(id);
        ville.setVille(villeParam);
        ville.setCodePostal(codePostal);
        villeRepository.save(ville);

        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return new RedirectView(route.getUrl());
    }

    @GetMapping("/ville/delete/{id}/")
    public String delete(Principal principal,@PathVariable Integer id, Model model) {

        VilleRoute route = new VilleRoute();
        model.addAttribute("route",route);

        villeRepository.deleteById(id);
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        model.addAttribute("villes", villeRepository.findAll());

        return route.getTemplate();
    }



}
