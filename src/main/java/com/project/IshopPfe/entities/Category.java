package com.project.IshopPfe.entities;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.*;
import org.springframework.context.annotation.Lazy;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name="category")
@Table(name="category")
public class Category implements Serializable  {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nomCategory;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
   private Set<sous_category> ss_cat=new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Category(){

    }
    public Category( String nomCategory) {

        this.nomCategory = nomCategory;
    }
    public String getNomCategory() {
        return nomCategory;
    }
    public void setNomCategory(String nomCategory) {
        this.nomCategory = nomCategory;
    }

}
