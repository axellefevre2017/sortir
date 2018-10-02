package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.site.SiteEditRoute;
import com.sortir.sortir.controller.route.site.SiteRoute;
import com.sortir.sortir.controller.route.ville.VilleEditRoute;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/site/edit/{id}/")
    public String edit(@PathVariable Integer id, Model model){

        SiteEditRoute route = new SiteEditRoute();
        model.addAttribute("route",route);

        model.addAttribute("site", siteRepository.findById(id).get());

        return route.getTemplate();
    }

    @PostMapping("/site/edit/{id}/")
    public RedirectView editValidation(@PathVariable Integer id, @RequestParam("site") String site, Model model){

        SiteRoute route = new SiteRoute();
        model.addAttribute("route",route);

        Site site1 = siteRepository.getOne(id);
        site1.setLibelle(site);
        siteRepository.save(site1);

        model.addAttribute("sites", siteRepository.findAll());

        return new RedirectView(route.getUrl());
    }

    @GetMapping("/site/delete/{id}/")
    public String delete(@PathVariable Integer id, Model model) {

        SiteRoute route = new SiteRoute();
        model.addAttribute("route",route);

        siteRepository.deleteById(id);

        model.addAttribute("sites", siteRepository.findAll());

        return route.getTemplate();
    }



}