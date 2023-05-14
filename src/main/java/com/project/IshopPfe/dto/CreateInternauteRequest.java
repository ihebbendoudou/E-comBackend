package com.project.IshopPfe.dto;

public class CreateInternauteRequest {
    private long tel;
    private String password;
    private String login;
    private String email;
    private String adresse;
    private String nom;

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private String prenom;
    public CreateInternauteRequest(String email,String password){
        this.email=email;
        this.password=password;
    }

    public CreateInternauteRequest(){}

    public CreateInternauteRequest(long tel, String password, String adresse,String login, String email, String nom, String prenom) {
        this.tel = tel;
        this.password = password;
        this.adresse=adresse;
        this.login = login;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
