package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtatRepository extends JpaRepository<Etat, Integer> {

    List<Etat> findAll();

    Optional<Etat> findById(Integer id);

}
