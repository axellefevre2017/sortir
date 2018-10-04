package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    @Override
    List<Participant> findAll();

    Optional<Participant> findById(Integer id);

    Participant findByPseudo(String pseudo);

    @Query(value = "SELECT COUNT(*) FROM Participants WHERE pseudo = :pseudo", nativeQuery = true)
    Integer findIfExists(@Param("pseudo") String pseudo);

    @Override
    <S extends Participant> S saveAndFlush(S s);
}
