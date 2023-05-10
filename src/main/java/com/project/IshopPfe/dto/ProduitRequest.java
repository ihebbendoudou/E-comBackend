package com.project.IshopPfe.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProduitRequest {

    public String labelle;
    public String description;
    public double prix;
    public Long idSousCategory;
    public Long idClient;
    public int Status;

//    public ProduitRequest(String lebelle, String description, double prix, Long idSousCategory,Long idClient) {
//        this.lebelle = lebelle;
//        this.description = description;
//        this.prix = prix;
//        this.idSousCategory = idSousCategory;
//        this.idClient=idClient;
//    }

    public ProduitRequest() {
    }
}
