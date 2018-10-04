package com.sortir.sortir.service;

import com.sortir.sortir.entity.Participant;
import com.sortir.sortir.entity.Ville;
import com.sortir.sortir.repository.ParticipantRepository;
import com.sortir.sortir.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    VilleRepository villeRepository;

    public Participant save(Integer id, String pseudo, String nom, String prenom, String telephone, String mail, String password, Integer ville) {

        Participant participant = participantRepository.getOne(id);
        participant.setNom(nom);
        participant.setPrenom(prenom);
        participant.setMail(mail);
        participant.setPseudo(pseudo);
        participant.setTelephone(telephone);

        Ville newVille = villeRepository.getOne(ville);

        if (password != null || password.isEmpty()) {

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            participant.setPassword(bCryptPasswordEncoder.encode(password));
        }

        participant.setVille(newVille);

        return participantRepository.saveAndFlush(participant);
    }

}
