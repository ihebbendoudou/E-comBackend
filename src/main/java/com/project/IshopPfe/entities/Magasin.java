package com.project.IshopPfe.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "magasin")
@Table(name = "magasin")
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
public class Magasin extends Client{



    public Magasin() {
    }

    public Magasin(Long tel, String password, String email,String login,String adresse, String intitule, String matriculeF) {
        super(tel,password,login,email);
        this.adresse = adresse;
        this.intitule = intitule;
        MatriculeF = matriculeF;
    }

    @OneToMany
    private Set<Coupon> coupons=new HashSet<>();


    private String adresse;
    private String intitule;
    private String MatriculeF;


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getMatriculeF() {
        return MatriculeF;
    }

    public void setMatriculeF(String matriculeF) {
        MatriculeF = matriculeF;
    }






}
