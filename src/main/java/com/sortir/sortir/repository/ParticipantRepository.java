package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    @Override
    List<Participant> findAll();

    Optional<Participant> findById(Integer id);

    Participant findByPseudo(String pseudo);
}
