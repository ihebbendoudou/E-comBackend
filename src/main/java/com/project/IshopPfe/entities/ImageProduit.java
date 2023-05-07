package com.project.IshopPfe.entities;

import jakarta.persistence.*;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Entity(name = "imageProduit")
@Table(name = "imageProduit")
public class ImageProduit implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Produit produit;

    String path;


    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ImageProduit(Produit produit, String path) {
        this.produit = produit;
        this.path = path;
    }
    public ImageProduit(){}


    public ImageProduit(Long id, Produit produit, String path) {
        this.id = id;
        this.produit = produit;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
