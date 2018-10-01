package com.sortir.sortir.service;

import com.sortir.sortir.entity.Participant;
import com.sortir.sortir.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    public List<Participant> findAll(){


        return participantRepository.findAll();
    }

}
