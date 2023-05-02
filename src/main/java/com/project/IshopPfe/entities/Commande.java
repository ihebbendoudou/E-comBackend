package com.project.IshopPfe.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name = "commande")
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long RefCommande;
    private Double prix;

    public SteLivraison getSteLivraison() {
        return steLivraison;
    }

    public void setSteLivraison(SteLivraison steLivraison) {
        this.steLivraison = steLivraison;
    }

    @OneToOne(mappedBy = "commande")
    @NotFound(action= NotFoundAction.IGNORE)
    private SteLivraison steLivraison;
    public Commande(Long refCommande, Double prix, SteLivraison steLivraison, int qunatite, Client client, Annonce annonce) {
        RefCommande = refCommande;
        this.prix = prix;
        this.steLivraison = steLivraison;
        this.qunatite = qunatite;
        this.client = client;
        this.annonce = annonce;
    }

    public Commande() {
    }

    public Long getRefCommande() {
        return RefCommande;
    }

    public void setRefCommande(Long refCommande) {
        RefCommande = refCommande;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getQunatite() {
        return qunatite;
    }

    public void setQunatite(int qunatite) {
        this.qunatite = qunatite;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    private int qunatite;
    @ManyToOne
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "annonceId", referencedColumnName = "id")
    private Annonce  annonce;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
