package com.project.IshopPfe.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "sous_category")
@Entity(name="sous_category")
public class sous_category implements Serializable  {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public sous_category(Long id, String nom_sous_category) {
        this.id = id;
        this.nom_sous_category = nom_sous_category;
    }

    public String getNom_sous_category() {
        return nom_sous_category;
    }

    public void setNom_sous_category(String nom_sous_category) {
        this.nom_sous_category = nom_sous_category;
    }
    private String nom_sous_category;
    @Basic(fetch=FetchType.EAGER)
    @ManyToOne
     private Category category;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Produit> produits=new HashSet<>();


    public sous_category(String nom_sous_category, Category category) {
        this.nom_sous_category = nom_sous_category;
        this.category = category;
    }

    public sous_category(){}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
