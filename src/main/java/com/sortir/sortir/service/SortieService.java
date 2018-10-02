package com.sortir.sortir.service;

import com.sortir.sortir.entity.Etat;
import com.sortir.sortir.entity.Lieu;
import com.sortir.sortir.entity.Participant;
import com.sortir.sortir.entity.Sortie;
import com.sortir.sortir.repository.EtatRepository;
import com.sortir.sortir.repository.LieuRepository;
import com.sortir.sortir.repository.ParticipantRepository;
import com.sortir.sortir.repository.SortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    ParticipantRepository participantRepository;

    @Autowired
    LieuRepository lieuRepository;

    public List<Sortie> findAll(){


        return sortieRepository.findAll();
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

}
