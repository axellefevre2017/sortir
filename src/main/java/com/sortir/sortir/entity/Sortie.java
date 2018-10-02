package com.sortir.sortir.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity(name = "sorties")
public class Sortie {

    @Id
    @Column(name="no_sortie")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nom")
    private String nom;

    @Column(name="datedebut")
    private Date dateDebut;

    @Column(name="duree")
    private Integer duree;

    @Column(name="datecloture")
    private Date dateLimiteInscription;

    @Column(name="nbinscriptionsmax")
    private Integer nbInscriptionsMax;

    @Column(name="descriptioninfos")
    private String infosSortie;

    @Column(name="urlphoto")
    private String urlPhoto;

    @JoinColumn(name="organisateur")
    @ManyToOne
    private Participant organisateur;

    @JoinColumn(name="lieux_no_lieu")
    @ManyToOne
    private Lieu lieu;

    @JoinColumn(name="etats_no_etat")
    @ManyToOne
    private Etat etat;

    public Sortie(Integer id, String nom, Date dateDebut, Integer duree, Date dateLimiteInscription, Integer nbInscriptionsMax, String infosSortie, String urlPhoto, Participant organisateur, Lieu lieu, Etat etat) {
        this.id = id;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.dateLimiteInscription = dateLimiteInscription;
        this.nbInscriptionsMax = nbInscriptionsMax;
        this.infosSortie = infosSortie;
        this.urlPhoto = urlPhoto;
        this.organisateur = organisateur;
        this.lieu = lieu;
        this.etat = etat;
    }

    public Sortie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Date getDateLimiteInscription() {
        return dateLimiteInscription;
    }

    public void setDateLimiteInscription(Date dateLimiteInscription) {
        this.dateLimiteInscription = dateLimiteInscription;
    }

    public Integer getNbInscriptionsMax() {
        return nbInscriptionsMax;
    }

    public void setNbInscriptionsMax(Integer nbInscriptionsMax) {
        this.nbInscriptionsMax = nbInscriptionsMax;
    }

    public String getInfosSortie() {
        return infosSortie;
    }

    public void setInfosSortie(String infosSortie) {
        this.infosSortie = infosSortie;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Participant getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Participant organisateur) {
        this.organisateur = organisateur;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
