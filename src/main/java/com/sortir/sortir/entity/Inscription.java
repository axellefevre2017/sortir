package com.sortir.sortir.entity;

import com.sortir.sortir.entity.pk.InscriptionPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="inscriptions")
public class Inscription {

        @EmbeddedId
        private InscriptionPk id;

        public Inscription(InscriptionPk id) {
                this.id = id;
        }

        public Inscription() {
        }

        public InscriptionPk getId() {
                return id;
        }

        public void setId(InscriptionPk id) {
                this.id = id;
        }
}
