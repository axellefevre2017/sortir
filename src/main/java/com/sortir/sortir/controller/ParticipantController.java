package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.ParticipantRoute;
import com.sortir.sortir.repository.InscriptionRepository;
import com.sortir.sortir.repository.ParticipantRepository;
import com.sortir.sortir.repository.SortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ParticipantController {

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    SortieRepository sortieRepository;


    List<String> success = new ArrayList<>();

    List<String> errors = new ArrayList<>();

    @GetMapping("/participant/")
    public String participant(Model model, Principal principal) {

        ParticipantRoute route = new ParticipantRoute();
        model.addAttribute("route", route);

        model.addAttribute("participants", participantRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        return route.getTemplate();
    }


}
