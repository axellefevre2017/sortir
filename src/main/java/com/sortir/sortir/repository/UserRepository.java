package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Participant, Integer> {

    Participant findByPseudo(String username);
}