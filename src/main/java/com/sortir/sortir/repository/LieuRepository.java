package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LieuRepository extends JpaRepository<Lieu, Integer> {

    @Override
    List<Lieu> findAll();

    Optional<Lieu> findById(Integer id);
}
