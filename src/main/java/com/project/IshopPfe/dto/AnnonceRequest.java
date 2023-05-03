package com.project.IshopPfe.dto;

import java.sql.Date;

public class AnnonceRequest {
    public Long IdClient;
    public Date Creation;
    public Date maj;
    public String nomAnnonce;
    public Long ProduitId;

    public AnnonceRequest(Long idClient, Date creation, Date maj, String nomAnnonce, Long ProduitId) {
        IdClient = idClient;
        Creation = creation;
        this.maj = maj;
        this.nomAnnonce = nomAnnonce;
        ProduitId = ProduitId;
    }

    public Long getIdClient() {
        return IdClient;
    }

    public void setIdClient(Long idClient) {
        IdClient = idClient;
    }

    public Date getCreation() {
        return Creation;
    }

    public void setCreation(Date creation) {
        Creation = creation;
    }

    public Date getMaj() {
        return maj;
    }

    public void setMaj(Date maj) {
        this.maj = maj;
    }

    public String getNomAnnonce() {
        return nomAnnonce;
    }

    public void setNomAnnonce(String nomAnnonce) {
        this.nomAnnonce = nomAnnonce;
    }

}
