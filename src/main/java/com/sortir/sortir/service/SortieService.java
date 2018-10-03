package com.sortir.sortir.service;

import com.sortir.sortir.controller.dto.SortieDto;
import com.sortir.sortir.entity.*;
import com.sortir.sortir.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SortieService {

    @Autowired
    SortieRepository sortieRepository;

    @Autowired
    EtatRepository etatRepository;

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    LieuRepository lieuRepository;


    public List<SortieDto> findAll(){

        List<SortieDto> sortieDtos = new ArrayList<>();


        for(int i=0;i<sortieRepository.findAll().size();i++){

            SortieDto sortieDto = new SortieDto();
            sortieDto.setId(sortieRepository.findAll().get(i).getId());
            sortieDto.setNom(sortieRepository.findAll().get(i).getNom());
            sortieDto.setDate(sortieRepository.findAll().get(i).getDateDebut());
            sortieDto.setCloture(sortieRepository.findAll().get(i).getDateLimiteInscription());
            sortieDto.setMax(sortieRepository.findAll().get(i).getNbInscriptionsMax());
            sortieDto.setParticipant(sortieRepository.findAll().get(i).getOrganisateur());
            sortieDto.setEtat(sortieRepository.findAll().get(i).getEtat());
            sortieDto.setParticipant(sortieRepository.findAll().get(i).getOrganisateur());

            if(inscriptionRepository.countBySortieAndParticipant(sortieRepository.findAll().get(i).getId(),sortieRepository.findAll().get(i).getOrganisateur().getId())==0){
                sortieDto.setInscrit(false);
            }else{
                sortieDto.setInscrit(true);
            }

            sortieDto.setNb(inscriptionRepository.countBySortie(sortieRepository.findAll().get(i).getId()));

            sortieDtos.add(sortieDto);

        }


        return sortieDtos;
    }

    public Sortie add(String nom, Date date, Integer duree, Date limite, Integer nbMax, String infos, Integer organisateur, Integer lieu, Integer etat){

        Sortie sortie = new Sortie();

        Optional<Etat> etatObjet = etatRepository.findById(etat);
        Optional<Participant> organisateurObjet = participantRepository.findById(organisateur);
        Optional<Lieu> lieuObjet = lieuRepository.findById(lieu);

        sortie.setNom(nom);
        sortie.setDateDebut(date);
        sortie.setDuree(duree);
        sortie.setDateLimiteInscription(limite);
        sortie.setNbInscriptionsMax(nbMax);
        sortie.setInfosSortie(infos);
        sortie.setEtat(etatObjet.get());
        sortie.setOrganisateur(organisateurObjet.get());
        sortie.setLieu(lieuObjet.get());


        return sortieRepository.save(sortie);
    }

    public Sortie edit(Integer id,String nom, Date date, Integer duree, Date limite, Integer nbMax, String infos, Integer organisateur, Integer lieu, Integer etat){



        Sortie sortie = sortieRepository.getOne(id);

        Optional<Etat> etatObjet = etatRepository.findById(etat);
        Optional<Participant> organisateurObjet = participantRepository.findById(organisateur);
        Optional<Lieu> lieuObjet = lieuRepository.findById(lieu);

        sortie.setNom(nom);
        sortie.setDateDebut(date);
        sortie.setDuree(duree);
        sortie.setDateLimiteInscription(limite);
        sortie.setNbInscriptionsMax(nbMax);
        sortie.setInfosSortie(infos);
        sortie.setEtat(etatObjet.get());
        sortie.setOrganisateur(organisateurObjet.get());
        sortie.setLieu(lieuObjet.get());


        return sortieRepository.save(sortie);
    }

    public void delete(Integer id){

        sortieRepository.deleteById(id);
    }

    public Optional<Sortie> findById(Integer id){

        return sortieRepository.findById(id);
    }

    /*public List<Sortie> filter(Site site, String nom, Date debut, Date fin, Boolean organisateur,Boolean inscrit, Boolean noninscrit, Boolean passe){


        return sortieRepository.
    }*/

}
