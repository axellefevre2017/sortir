package com.sortir.sortir.entity;

import javax.persistence.*;

@Entity(name = "participants")
public class Participant {

    @Id
    @Column(name="no_participant")
    private Integer id;
    private String pseudo;
    private String password;
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private Boolean administrateur;
    private Boolean actif;
    private String photo;

    @JoinColumn(name="villes_no_ville")
    @ManyToOne
    private Ville ville;

    public Participant() {
    }

    public Participant(Integer id, String pseudo, String password, String nom, String prenom, String telephone, String mail, Boolean administrateur, Boolean actif, String photo, Ville ville) {
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.administrateur = administrateur;
        this.actif = actif;
        this.photo = photo;
        this.ville = ville;
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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}
