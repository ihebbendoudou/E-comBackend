package com.project.IshopPfe.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.sql.Date;

@Table(name = "annonce")
@Entity(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date date_Ceation_Annonce;
    private Date date_mise_a_jour_Annonce;
    private String nom_annonce;

    @ManyToOne
    private Client client;
    @OneToOne(mappedBy = "annonce")
    private Commande  commande;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produitId", referencedColumnName = "id")
    private Produit produit;


    public Annonce() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Annonce(Date date_Ceation_Annonce, Date date_mise_a_jour_Annonce, String nom_annonce, Client client, Produit produit) {
        this.date_Ceation_Annonce = date_Ceation_Annonce;
        this.date_mise_a_jour_Annonce = date_mise_a_jour_Annonce;
        this.nom_annonce = nom_annonce;
        this.client = client;
        this.produit = produit;
    }
}
