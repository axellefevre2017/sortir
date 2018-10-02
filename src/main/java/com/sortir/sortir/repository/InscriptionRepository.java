package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Inscription;
import com.sortir.sortir.entity.Sortie;
import com.sortir.sortir.entity.pk.InscriptionPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, InscriptionPk> {

    List<Inscription> findAll();

}
