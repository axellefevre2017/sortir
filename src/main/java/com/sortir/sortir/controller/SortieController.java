package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.sortie.SortieAddRoute;
import com.sortir.sortir.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SortieController {

    @Autowired
    SortieService sortieService;

    @GetMapping("/sortie/add/")
    public String getHome(Model model){

        SortieAddRoute route = new SortieAddRoute();
        model.addAttribute("route",route);

        model.addAttribute("sorties", sortieService.findAll());

        return route.getTemplate();
    }



}
