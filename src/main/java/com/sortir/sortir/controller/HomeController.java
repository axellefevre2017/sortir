package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.ProfilRoute;
import com.sortir.sortir.repository.ParticipantRepository;
import com.sortir.sortir.repository.SiteRepository;
import com.sortir.sortir.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    SortieService sortieService;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    SiteRepository siteRepository;

    @GetMapping("/")
    public String getHome(Model model, Principal principal){

        HomeRoute route = new HomeRoute();
        model.addAttribute("route",route);

        model.addAttribute("sites", siteRepository.findAll());
        model.addAttribute("sorties", sortieService.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }

    @GetMapping("/profil/")
    public String getProfil(Model model, Principal principal){

        ProfilRoute route = new ProfilRoute();
        model.addAttribute("route",route);

        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }



}
