package com.project.IshopPfe.entities;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String value;

    private int pourcentage;
    @ManyToOne
    public Magasin magasin;

    @OneToMany
    public Set<Produit> produits= new HashSet();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}