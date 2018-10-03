package com.sortir.sortir.repository;

import com.sortir.sortir.entity.Inscription;
import com.sortir.sortir.entity.Participant;
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

    @Query(value="SELECT COUNT(*) FROM Inscriptions a, Sorties b, Participants c where a.sorties_no_sortie=b.no_sortie and c.no_participant=a.participants_no_participant and a.sorties_no_sortie = :sortie and a.participants_no_participant = :organisateur", nativeQuery = true)
    Integer countBySortieAndParticipant(@Param("sortie") Integer sortie, @Param("organisateur") Integer organisateur);

    @Query(value="SELECT COUNT(*) FROM Inscriptions a, Sorties b where a.sorties_no_sortie=b.no_sortie and a.sorties_no_sortie = :sortie", nativeQuery = true)
    Integer countBySortie(@Param("sortie") Integer sortie);
}
