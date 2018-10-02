package com.sortir.sortir.service;

import com.sortir.sortir.entity.Inscription;
import com.sortir.sortir.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {

    @Autowired
    InscriptionRepository inscriptionRepository;

    public List<Inscription> findAll(){


        return inscriptionRepository.findAll();
    }

}
