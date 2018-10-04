package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Site;
import com.sortir.sortir.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {

    @Override
    List<Site> findAll();



}
