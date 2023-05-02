package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.AnnonceRepository;
import com.project.IshopPfe.dto.AnnonceRequest;
import com.project.IshopPfe.entities.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepository AnnonceRepo;

     public void CreateAnnonce(AnnonceRequest annonce){
       //  Annonce an= new Annonce();


     }
}
