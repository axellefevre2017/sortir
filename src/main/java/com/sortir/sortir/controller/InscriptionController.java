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

        if (checkIfInscrit(sortie,principal.getName()) && checkIfAssezDePlace(sortie)) {
            inscriptionRepository.save(inscription);
            success.removeAll(success);
            success.add("Vous êtes désormais inscrit à la sortie "+ sortieRepository.getOne(sortie).getNom() + " .");
            ra.addFlashAttribute("success", success);
        } else {
            ra.addFlashAttribute("errors", errors);
        }


        return new RedirectView("/sortie/show/"+ sortie+"/");
    }

    @GetMapping("/sortie/show/{id}/desinscription/")
    public RedirectView desinscription(Model model, RedirectAttributes ra, Principal principal, @PathVariable("id") Integer sortie){

        Inscription inscription = inscriptionRepository.findByParticipantAndSortie(sortieRepository.getOne(sortie).getId(),participantRepository.findByPseudo(principal.getName()).getId());

        if (checkIfDesinscrit(sortie,principal.getName())) {
            success.removeAll(success);
            success.add("Vous êtes désormais désinscrits de la sortie "+sortieRepository.getOne(sortie).getNom() + " .");
            ra.addFlashAttribute("success", success);
            inscriptionRepository.delete(inscription);
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

    public Boolean checkIfAssezDePlace(Integer sortie){

        //On vide la liste d'erreur
        errors.removeAll(errors);

        Integer nombreDePlace = sortieRepository.getOne(sortie).getNbInscriptionsMax();

        if(inscriptionRepository.countBySortie(sortie)>=nombreDePlace){
            errors.add("Il n'y a plus de place pour cette sortie.");
        }
        if(sortieRepository.getOne(sortie).getDateLimiteInscription().before(new Date())){
            errors.add("Les inscriptions sont désormais fermées pour cette sortie.");
        }
        if(sortieRepository.getOne(sortie).getEtat().getId()!=3){
            errors.add("Cette sortie n'est pas publiée, il est impossible de s'inscrire.");
        }


        if (!errors.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkIfDesinscrit(Integer sortie, String user){

        //On vide la liste d'erreur
        errors.removeAll(errors);

        if(inscriptionRepository.countBySortieAndParticipant(sortie,participantRepository.findByPseudo(user).getId())==0){
            errors.add("Vous n'êtes pas inscrits à cette sortie.");
        }

        if (!errors.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
