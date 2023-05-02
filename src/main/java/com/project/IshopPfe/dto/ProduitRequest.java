package com.project.IshopPfe.dto;

public class ProduitRequest {

    public String lebelle;
    public String description;
    public double prix;
    public Long idSousCategory;
    public Long idClient;

    public ProduitRequest(String lebelle, String description, double prix, Long idSousCategory,Long idClient) {
        this.lebelle = lebelle;
        this.description = description;
        this.prix = prix;
        this.idSousCategory = idSousCategory;
        this.idClient=idClient;
    }

    public ProduitRequest() {
    }
}
