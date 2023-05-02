package com.project.IshopPfe.entities;

import jakarta.persistence.*;

@Entity(name = "internaute")
@Table(name = "internaute")
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
public class Internaute extends Client{
    public Internaute() {
    }

    public Internaute(Long tel, String password, String login, String email, String nom, String prenom) {
        super(tel,password,login,email);
        this.nom = nom;
        this.prenom = prenom;

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

    private String nom;
        private String prenom;



}
