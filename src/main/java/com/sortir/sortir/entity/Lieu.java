package com.sortir.sortir.entity;

import javax.persistence.*;

@Entity(name="LIEUX")
public class Lieu {

    @Id
    @Column(name="no_lieu")
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


}
