package com.sortir.sortir.entity;

import javax.persistence.*;

@Entity(name="villes")
public class Ville {

    @Id
    @Column(name="no_ville")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nom_ville")
    private String ville;

    @Column(name="code_postal")
    private String codePostal;

    public Ville() {
    }

    public Ville(Integer id, String ville, String codePostal) {
        this.id = id;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
