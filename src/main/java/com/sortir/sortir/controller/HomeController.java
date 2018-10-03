package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.HomeRoute;
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

    @GetMapping("/")
    public String getHome(Model model, Principal principal){

        HomeRoute route = new HomeRoute();
        model.addAttribute("route",route);

        model.addAttribute("sorties", sortieService.findAll());
        model.addAttribute("user", principal.getName());

        return route.getTemplate();
    }



}
