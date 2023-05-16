package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.CategoryRepository;
import com.project.IshopPfe.dao.SousCategoryRepository;
import com.project.IshopPfe.dto.SousCategoryRequest;
import com.project.IshopPfe.entities.Category;
import com.project.IshopPfe.entities.sous_category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SousCategoryService {
    private final SousCategoryRepository sousCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    public SousCategoryService(SousCategoryRepository sousCategoryRepository) {
        this.sousCategoryRepository = sousCategoryRepository;
    }

    public List<sous_category> getAllSousCategory(){
        return (List<sous_category>) sousCategoryRepository.findAll();
    }

    public List<sous_category> findByCategory(Long id){
        return  sousCategoryRepository.findByCategory_id(id);
    }


    public List<sous_category>getByCatSousCat(){
        return sousCategoryRepository.findAllByOrderByCategoryAsc();
    }

    public sous_category getSousCategoryById(Long id){
        return sousCategoryRepository.findById(id).get();
    }
    public sous_category findSousCategorybyNom(String st){
        return sousCategoryRepository.findBynom_sous_category(st); }

    public sous_category createSousCategory(SousCategoryRequest request) {
        Category category= categoryRepository.findById(request.idCategory).get();
        sous_category ss = new sous_category();
        ss.setNom_sous_category(request.NomSousCategory);
        ss.setCategory(category);
        return sousCategoryRepository.save(ss);
    }
    public void deleteSousCategory(sous_category sc){
        sousCategoryRepository.delete(sc);
    }

    public Boolean  deleteSousCategoryByid(Long id){
        if(id!=null) {
            sousCategoryRepository.deleteById(id);
            return true;
        }else return false;
    }
    public void  deleteSousCategoryByNom(String  nom){
        sous_category objet= sousCategoryRepository.findBynom_sous_category(nom);
        sousCategoryRepository.delete(objet);
    }

    public List<sous_category> getSousCategoryByCategoryId(Long id) {
        return sousCategoryRepository.findByCategory_id(id);
    }
    public List<sous_category> getSousCategoryByCategoryIddd(Long id) {
        return sousCategoryRepository.getSousCategoryByCategoryIddd(id);
    }

    public sous_category updateSousCategoryById(Long id , SousCategoryRequest sc){
        sous_category sCateg = sousCategoryRepository.findById(id).get();
        sCateg.setNom_sous_category(sc.NomSousCategory);
        return sousCategoryRepository.save(sCateg);
    }

}
