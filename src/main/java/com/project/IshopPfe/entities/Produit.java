package com.project.IshopPfe.entities;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "produit")
@Entity(name = "produit")
public class Produit implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String labelle;
    private double prix;
    private String description;
    @ManyToOne
    @NotFound(action= NotFoundAction.IGNORE)
    private Coupon coupon;
    @ManyToOne
    private Client client ;

    @OneToOne(mappedBy = "produit")
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


    @ManyToOne
    @ToString.Exclude
    private sous_category sousCategory;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ImageProduit> images=new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<ImageProduit> getImages() {
        return images;
    }

    public void setImages(Set<ImageProduit> images) {
        this.images = images;
    }

    public Produit(String labelle, double prix, String description, Coupon coupon, Client client, sous_category sousCategory, Set<ImageProduit> images) {
        this.labelle = labelle;
        this.prix = prix;
        this.description = description;
        this.coupon = coupon;
        this.client = client;
        this.sousCategory = sousCategory;
        this.images = images;
    }

    public Produit(String labelle, double prix, String description, sous_category sousCategory, Set<ImageProduit> images) {
        this.labelle = labelle;
        this.prix = prix;
        this.description = description;
        this.sousCategory = sousCategory;
        this.images = images;
    }

    public Produit(){}
}
