package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Participant;
import com.sortir.sortir.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {

    @Override
    List<Ville> findAll();

}
