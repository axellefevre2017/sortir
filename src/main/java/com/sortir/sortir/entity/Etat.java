package com.sortir.sortir.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="etats")
public class Etat {

    @Id
    @Column(name = "no_etat")
    private Integer id;

    @Column(name="libelle")
    private String libelle;

    public Etat(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Etat() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
