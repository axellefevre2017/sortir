package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SortieRepository extends JpaRepository<Sortie, Integer> {

    List<Sortie> findAll();

}
