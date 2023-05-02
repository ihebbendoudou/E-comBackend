package com.project.IshopPfe.dto;

public class SousCategoryRequest {
    public String NomSousCategory;
    private Long idCategory;


    public SousCategoryRequest(String nomSousCategory, Long idCategory) {
        NomSousCategory = nomSousCategory;
        this.idCategory = idCategory;
    }
    public SousCategoryRequest(){}

    public String getNomSousCategory() {
        return NomSousCategory;
    }

    public void setNomSousCategory(String nomSousCategory) {
        NomSousCategory = nomSousCategory;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }



}
