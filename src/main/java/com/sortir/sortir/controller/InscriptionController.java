package com.sortir.sortir.controller;

import com.sortir.sortir.entity.Inscription;
import com.sortir.sortir.entity.pk.InscriptionPk;
import com.sortir.sortir.repository.InscriptionRepository;
import com.sortir.sortir.repository.ParticipantRepository;
import com.sortir.sortir.repository.SortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class InscriptionController {

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    SortieRepository sortieRepository;


    List<String> success = new ArrayList<>();

    List<String> errors = new ArrayList<>();

    @GetMapping("/sortie/show/{id}/inscription/")
    public RedirectView inscription(Model model, RedirectAttributes ra, Principal principal, @PathVariable("id") Integer sortie){

        Inscription inscription = new Inscription();
        InscriptionPk inscriptionPk = new InscriptionPk();
        inscriptionPk.setDateInscription(new Date());
        inscriptionPk.setParticipant(participantRepository.findByPseudo(principal.getName()));
        inscriptionPk.setSortie(sortieRepository.getOne(sortie));
        inscription.setId(inscriptionPk);

        if (checkIfInscrit(sortie,principal.getName())) {
            inscriptionRepository.save(inscription);
            success.removeAll(success);
            success.add("Vous êtes désormais inscrit à la sortie "+ sortieRepository.getOne(sortie).getNom() + " .");
            ra.addFlashAttribute("success", success);
        } else {
            ra.addFlashAttribute("errors", errors);
        }


        return new RedirectView("/sortie/show/"+ sortie+"/");
    }

    public Boolean checkIfInscrit(Integer sortie, String user){

        //On vide la liste d'erreur
        errors.removeAll(errors);

        if(inscriptionRepository.countBySortieAndParticipant(sortie,participantRepository.findByPseudo(user).getId())>0){
            errors.add("Vous êtes déjà inscrit à cette sortie.");
        }

        if (!errors.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
