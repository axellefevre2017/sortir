package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    ParticipantService participantService;

    @GetMapping("/")
    public String getHome(Model model){

        HomeRoute route = new HomeRoute();
        model.addAttribute("route",route);

        model.addAttribute("participants",participantService.findAll());

        return route.getTemplate();
    }

    @GetMapping("/login")
    public String getLogin(){

        return "login";
    }


}
