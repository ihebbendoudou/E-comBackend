package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.ImageProduitRepository;
import com.project.IshopPfe.dao.ProduitRepository;
import com.project.IshopPfe.dao.SousCategoryRepository;
import com.project.IshopPfe.dto.ImageProduitRequest;
import com.project.IshopPfe.dto.ProduitRequest;
import com.project.IshopPfe.entities.ImageProduit;
import com.project.IshopPfe.entities.Produit;
import com.project.IshopPfe.entities.sous_category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageProduitService {

    @Autowired
    ImageProduitRepository imageProduitRepository;
    @Autowired
    ProduitRepository produitRepository;


    public ImageProduit saveImageProduit(ImageProduitRequest p) {
        Produit sc = produitRepository.findById(p.idProduit).get();
        ImageProduit img= new ImageProduit();
        img.setPath(p.libelle);
        img.setProduit(sc);
        return imageProduitRepository.save(img);


    } public ImageProduit updateImageProduit(ImageProduitRequest p) {
        Produit sc = produitRepository.findById(p.idProduit).get();
        ImageProduit img= new ImageProduit();
        img.setPath(p.libelle);
        img.setProduit(sc);
        return imageProduitRepository.save(img);


    }
    public void deleteProduit(ImageProduit p) {
        imageProduitRepository.delete(p);

    }
    public void deleteProduitById(Long id) {
        imageProduitRepository.deleteById(id);
    }
    public ImageProduit getImage(Long id) {
        return imageProduitRepository.findById(id).get();
    }
    public List<ImageProduit> getAllProduits() {
        return (List<ImageProduit>) imageProduitRepository.findAll();
    }
    public List <ImageProduit> getProduitByProduitId(Long id) {
        return imageProduitRepository.findByProduit_id(id);
    }

}
