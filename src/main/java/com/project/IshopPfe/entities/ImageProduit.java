package com.project.IshopPfe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

import java.io.Serializable;
import java.util.Optional;

@Entity(name = "imageProduit")
@Table(name = "imageProduit")
public class ImageProduit implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "produit_id")
    private Produit produit;


    private String path;

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
    public ImageProduit(){}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
