package com.project.IshopPfe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity(name = "annonce")
@Table(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

       //@JsonIgnore
        @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, orphanRemoval = true)
        @JoinColumn(name = "produit_id",referencedColumnName = "id")
        private Produit produit;
        private int idC;

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

        @CreationTimestamp
        private Instant dateCreation;
        @UpdateTimestamp
        private Instant dateMaj;
        @Lob
        @Column(name="nomAnnonce", length=1000)
        private String nomAnnonce;
    public Annonce() {
    }
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }


    public Instant getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Instant dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Instant getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(Instant dateMaj) {
        this.dateMaj = dateMaj;
    }

    public String getNomAnnonce() {
        return nomAnnonce;
    }

    public void setNomAnnonce(String nomAnnonce) {
        this.nomAnnonce = nomAnnonce;
    }
}
