package com.project.IshopPfe.service;

//import com.project.IshopPfe.dao.AnnonceRepository;
import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.dao.ProduitRepository;
import com.project.IshopPfe.dto.AnnonceRequest;
import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//
//
//
//public class AnnonceService {
//    @Autowired
//    AnnonceRepository AnnonceRepo;
//    @Autowired
//    ClientRepository clientRepository;
//    @Autowired
//    ProduitRepository produitRepository;
//
//
//    public Annonce CreateAnnonce(AnnonceRequest p){
//         Client cl= clientRepository.findById(p.IdClient).get();
//         Produit produit=produitRepository.findById(p.ProduitId).get();
//         Annonce a= new Annonce( p.nomAnnonce,cl,produit);
//         return AnnonceRepo.save(a);
//     }
//
//     public List<Annonce> getAll(){
//        return AnnonceRepo.findAll();
//     }
//
//    public Annonce getAnnonceById(Long id){
//        return AnnonceRepo.findById(id).get();
//    }
//
//    }
