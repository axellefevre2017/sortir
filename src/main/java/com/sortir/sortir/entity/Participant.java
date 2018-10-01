package com.sortir.sortir.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "participants")
public class Participant {

    @Id
    @Column(name="no_participant")
    private Integer id;
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private Boolean administrateur;
    private Boolean actif;

    public Participant() {
    }

    public Participant(Integer id, String nom, String prenom, String telephone, String mail, Boolean administrateur, Boolean actif) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.administrateur = administrateur;
        this.actif = actif;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Boolean administrateur) {
        this.administrateur = administrateur;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }
}
