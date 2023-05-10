package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.AnnonceRepository;
import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.dao.ProduitRepository;
import com.project.IshopPfe.dto.AnnonceRequest;
import com.project.IshopPfe.entities.Annonce;
import com.project.IshopPfe.entities.Category;
import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.entities.Produit;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnonceService {

    @Autowired
    AnnonceRepository AnnonceRepo;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    ProduitService produitService;

    public Annonce CreateAnnonce(AnnonceRequest p){
         Client cl= clientRepository.findById(p.IdClient).get();
         Produit produit=produitRepository.findById(p.ProduitId).get();
            produitService.updateSatut(produit);
         Annonce a= new Annonce();
         a.setNomAnnonce(p.nomAnnonce);
         a.setClient(cl);
         a.setProduit(produit);
//         a.setDateCreation(p.Creation);
//         a.setDateMaj(p.maj);
         return AnnonceRepo.save(a);
     }

     public List<Annonce> getAll(){
        return AnnonceRepo.findAll();
     }

        public Annonce AnnonceUpdate(long id, AnnonceRequest p) {
        Annonce a=AnnonceRepo.findById(id).get();
        Client cl= clientRepository.findById(p.IdClient).get();
        Produit produit=produitRepository.findById(p.ProduitId).get();
        a.setNomAnnonce(p.nomAnnonce);
        a.setClient(cl);
        a.setDateCreation(p.Creation);
        a.setDateMaj(p.maj);
        return AnnonceRepo.save(a);

    }
}
