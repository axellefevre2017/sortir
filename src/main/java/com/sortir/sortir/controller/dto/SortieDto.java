package com.sortir.sortir.controller.dto;

import com.sortir.sortir.entity.Etat;
import com.sortir.sortir.entity.Lieu;
import com.sortir.sortir.entity.Participant;

import java.util.Date;

public class SortieDto {

    private Integer id;
    private String nom;
    private Date date;
    private Date cloture;
    private Integer nb;
    private Integer max;
    private Etat etat;
    private Lieu lieu;
    private Boolean inscrit;
    private Participant participant;

    public SortieDto(Integer id, String nom, Date date, Date cloture, Lieu lieu, Integer nb, Integer max, Etat etat, Boolean inscrit, Participant participant) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.cloture = cloture;
        this.nb = nb;
        this.max = max;
        this.lieu = lieu;
        this.etat = etat;
        this.inscrit = inscrit;
        this.participant = participant;
    }

    public SortieDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCloture() {
        return cloture;
    }

    public void setCloture(Date cloture) {
        this.cloture = cloture;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getNb() {
        return nb;
    }

    public void setNb(Integer nb) {
        this.nb = nb;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Boolean getInscrit() {
        return inscrit;
    }

    public void setInscrit(Boolean inscrit) {
        this.inscrit = inscrit;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
