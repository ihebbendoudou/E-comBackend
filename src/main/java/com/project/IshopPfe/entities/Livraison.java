package com.project.IshopPfe.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "livraison")
@Table(name = "livraison")
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date dateLivraison;
    private double solde;
    @ManyToOne
    private SteLivraison steLivraison;
    public Livraison(){}

    public Livraison( Date dateLivraison, double solde, SteLivraison steLivraison) {
        this.dateLivraison = dateLivraison;
        this.solde = solde;
        this.steLivraison = steLivraison;
    }



    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public SteLivraison getSteLivraison() {
        return steLivraison;
    }

    public void setSteLivraison(SteLivraison steLivraison) {
        this.steLivraison = steLivraison;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
