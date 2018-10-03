package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.ProfilRoute;
import com.sortir.sortir.repository.LieuRepository;
import com.sortir.sortir.repository.ParticipantRepository;
import com.sortir.sortir.repository.SiteRepository;
import com.sortir.sortir.repository.VilleRepository;
import com.sortir.sortir.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.ParseException;

@Controller
public class HomeController {

    @Autowired
    SortieService sortieService;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    VilleRepository villeRepository;

    @Autowired
    LieuRepository lieuRepository;

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
        model.addAttribute("sorties", sortieService.filter(participantRepository.findByPseudo(principal.getName()),site, name_sortie, date_debut, date_fin, organisateur, inscrit, noninscrit, passees));
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @GetMapping("/profil/")
    public String getProfil(Model model, Principal principal) {

        ProfilRoute route = new ProfilRoute();
        model.addAttribute("route", route);

        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }


}
