package com.sortir.sortir.service;

import com.sortir.sortir.entity.Sortie;
import com.sortir.sortir.repository.SortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortieService {

    @Autowired
    SortieRepository sortieRepository;

    public List<Sortie> findAll(){


        return sortieRepository.findAll();
    }

}
