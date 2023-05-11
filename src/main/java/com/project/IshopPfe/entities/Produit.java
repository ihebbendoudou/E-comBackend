package com.project.IshopPfe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.util.*;

@Table(name = "produit")
@Entity(name = "produit")
public class Produit implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String labelle;
    private double prix;
    private String description;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action= NotFoundAction.IGNORE)
    private Coupon coupon;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client ;
    @JsonIgnore

    @OneToOne(mappedBy = "produit",fetch = FetchType.EAGER)
    private Commande  commande;


    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public List<ImageProduit> getImages() {
        return images;
    }

    public void setImages(List<ImageProduit> images) {
        this.images = images;
    }
    @JsonIgnore
    @ManyToOne
    @ToString.Exclude
    private sous_category sousCategory;
    @JsonIgnore
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<ImageProduit> images = new ArrayList<>();

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Value("${some.key:0}")
    private int statut;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabelle() {
        return labelle;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public sous_category getSousCategory() {
        return sousCategory;
    }

    public void setSousCategory(sous_category sousCategory) {
        this.sousCategory = sousCategory;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "produit",fetch = FetchType.EAGER)
    private Annonce annonce;

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }


    public Produit(){}
}
