package com.sortir.sortir.entity;

import javax.persistence.*;

@Entity(name = "sites")
public class Site {

    @Id
    @Column(name = "no_site")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_site")
    private String libelle;

    public Site() {
    }

    public Site(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
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
