package com.sortir.sortir.entity;

import javax.persistence.*;

@Entity(name="LIEUX")
public class Lieu {

    @Id
    @Column(name="no_lieu")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nom_lieu")
    private String libelle;

    @Column(name="rue")
    private String rue;

    @Column(name="latitude")
    private Float latitude;

    @Column(name="longitude")
    private Float longitude;

    @JoinColumn(name="villes_no_ville")
    @ManyToOne
    private Ville ville;

    public Lieu() {
    }

    public Lieu(Integer id, String libelle, String rue, Float latitude, Float longitude, Ville ville) {
        this.id = id;
        this.libelle = libelle;
        this.rue = rue;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ville = ville;
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

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}
