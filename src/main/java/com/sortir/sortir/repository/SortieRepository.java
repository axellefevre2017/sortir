package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SortieRepository extends JpaRepository<Sortie, Integer> {

    List<Sortie> findAll();

    Optional<Sortie> findById(Integer id);
}
