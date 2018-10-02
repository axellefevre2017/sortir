package com.sortir.sortir.entity;

import com.sortir.sortir.entity.pk.InscriptionPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="inscriptions")
public class Inscription {

        @EmbeddedId
        private InscriptionPk id;

}
