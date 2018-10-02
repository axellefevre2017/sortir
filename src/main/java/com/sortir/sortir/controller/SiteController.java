package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.site.SiteRoute;
import com.sortir.sortir.controller.route.ville.VilleRoute;
import com.sortir.sortir.entity.Site;
import com.sortir.sortir.entity.Ville;
import com.sortir.sortir.repository.LieuRepository;
import com.sortir.sortir.repository.SiteRepository;
import com.sortir.sortir.repository.VilleRepository;
import com.sortir.sortir.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {

    @Autowired
    SortieService sortieService;

    @Autowired
    SiteRepository siteRepository;

    @Autowired
    VilleRepository villeRepository;

    @GetMapping("/site/")
    public String add(Model model){

        SiteRoute route = new SiteRoute();
        model.addAttribute("route",route);

        model.addAttribute("sites", siteRepository.findAll());

        return route.getTemplate();
    }

    @PostMapping("/site/")
    public String addValidation(@RequestParam("site") String siteParam,Model model){

        SiteRoute route = new SiteRoute();
        model.addAttribute("route",route);

        Site site = new Site();
        site.setLibelle(siteParam);

        siteRepository.save(site);

        model.addAttribute("sites", siteRepository.findAll());

        return route.getTemplate();
    }

    @PostMapping("/site/rechercher/")
    public String search(@RequestParam("site") String siteParam,Model model){

        SiteRoute route = new SiteRoute();
        model.addAttribute("route",route);
        model.addAttribute("filtre", siteParam);
        model.addAttribute("sites", siteRepository.findAllByLibelleContaining(siteParam));

        return route.getTemplate();
    }



}
