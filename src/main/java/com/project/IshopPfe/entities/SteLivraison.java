package com.project.IshopPfe.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.HashSet;
import java.util.Set;

@Table(name = "stelivraison")
@Entity(name = "stelivraison")
public class SteLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long refSociete;
    private int tel;
    private String matriculeFiscale;
    private String intitule;
    private String adresse;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "commandeId", referencedColumnName = "id")
    private Commande commande;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Livraison> livraisons=new HashSet<>();


    public SteLivraison() {
    }

    public SteLivraison(Long refSociete, int tel, String matriculeFiscale, String intitule, String adresse, String email, Commande commande) {
        this.refSociete = refSociete;
        this.tel = tel;
        this.matriculeFiscale = matriculeFiscale;
        this.intitule = intitule;
        this.adresse = adresse;
        this.email = email;

    }

    public SteLivraison(Long refSociete, int tel, String matriculeFiscale, String intitule, String adresse, String email) {
        this.refSociete = refSociete;
        this.tel = tel;
        this.matriculeFiscale = matriculeFiscale;
        this.intitule = intitule;
        this.adresse = adresse;
        this.email = email;
        this.commande = commande;
        this.livraisons = livraisons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
