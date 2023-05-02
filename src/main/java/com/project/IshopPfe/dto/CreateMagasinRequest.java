package com.project.IshopPfe.dto;

public class CreateMagasinRequest {
    private Long tel;
    private String password;
    private String login;
    private String email;
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



    public CreateMagasinRequest(String email, String password){
        this.email=email;
        this.password=password;
    }

    public CreateMagasinRequest(){}

    public CreateMagasinRequest(Long tel, String password, String login, String email, String adresse, String matriculeF,String intitule) {
        this.tel = tel;
        this.password = password;
        this.login = login;
        this.email = email;
        this.intitule = intitule;
        this.MatriculeF=matriculeF;
        this.adresse=adresse;

    }

    public Long getTel() {
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


}
