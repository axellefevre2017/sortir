package com.sortir.sortir.entity.pk;


import com.sortir.sortir.entity.Participant;
import com.sortir.sortir.entity.Sortie;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

public class InscriptionPk implements Serializable {

    @Column(name="date_inscription")
    private Date dateInscription;

    @JoinColumn(name="sorties_no_sortie")
    @ManyToOne
    private Sortie sortie;

    @JoinColumn(name="participants_no_participant")
    @ManyToOne
    private Participant participant;


}
