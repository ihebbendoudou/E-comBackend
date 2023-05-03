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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Commande> commandes=new HashSet<>();


    public SteLivraison() {
    }

    public SteLivraison
            (Long refSociete, int tel, String matriculeFiscale, String intitule, String adresse, String email) {
        this.refSociete = refSociete;
        this.tel = tel;
        this.matriculeFiscale = matriculeFiscale;
        this.intitule = intitule;
        this.adresse = adresse;
        this.email = email;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRefSociete() {
        return refSociete;
    }

    public void setRefSociete(Long refSociete) {
        this.refSociete = refSociete;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getMatriculeFiscale() {
        return matriculeFiscale;
    }

    public void setMatriculeFiscale(String matriculeFiscale) {
        this.matriculeFiscale = matriculeFiscale;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }
}
