package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.dao.ProduitRepository;
import com.project.IshopPfe.dao.SousCategoryRepository;
import com.project.IshopPfe.dto.ProduitRequest;
import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.entities.Produit;
import com.project.IshopPfe.entities.sous_category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired ProduitRepository produitRepository;
    @Autowired
    SousCategoryRepository sousCategoryRepository;
    @Autowired
    ClientRepository clientRepository;


    public Produit saveProduit(ProduitRequest p) {
        sous_category sc = sousCategoryRepository.findById(p.idSousCategory).get();
        Client client= clientRepository.findById(p.idClient).get();
        Produit produit= new Produit();
        produit.setSousCategory(sc);
        produit.setDescription(p.description);
        produit.setLabelle(p.lebelle);
        produit.setPrix(p.prix);
        produit.setClient(client);
        return produitRepository.save(produit);
    }
    public Produit updateProduit(ProduitRequest p) {
        sous_category sc = sousCategoryRepository.findById(p.idSousCategory).get();

        Produit produit= new Produit();
        produit.setSousCategory(sc);
        produit.setDescription(p.description);
        produit.setLabelle(p.lebelle);
        produit.setPrix(p.prix);
       return produitRepository.save(produit);

    }
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);

    }
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }
    public List<Produit> getAllProduits() {
        return (List<Produit>) produitRepository.findAll();
    }
    public Produit getProduitByNom(String nom) {
        return produitRepository.findByLabelle(nom);
    }

}
