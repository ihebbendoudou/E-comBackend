package com.project.IshopPfe.dto;

import java.sql.Date;

public class AnnonceRequest {
    private Long IdClient;
    private Date Creation;
    private Date maj;
    private String nomAnnonce;
    private Long IdSousCategory;

    public AnnonceRequest(Long idClient, Date creation, Date maj, String nomAnnonce, Long idSousCategory) {
        IdClient = idClient;
        Creation = creation;
        this.maj = maj;
        this.nomAnnonce = nomAnnonce;
        IdSousCategory = idSousCategory;
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

    public Long getIdSousCategory() {
        return IdSousCategory;
    }

    public void setIdSousCategory(Long idSousCategory) {
        IdSousCategory = idSousCategory;
    }
}
