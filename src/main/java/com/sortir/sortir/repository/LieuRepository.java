package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Lieu;
import com.sortir.sortir.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LieuRepository extends JpaRepository<Lieu, Integer> {

    @Override
    List<Lieu> findAll();
}
