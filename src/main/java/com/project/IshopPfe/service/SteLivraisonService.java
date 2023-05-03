package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.SteLivraisonRepository;
import com.project.IshopPfe.entities.SteLivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SteLivraisonService {
    @Autowired
    SteLivraisonRepository steLivraisonRepository;


    public SteLivraison create(SteLivraison steLivraison){
        return steLivraisonRepository.save(steLivraison);
    }
    public SteLivraison update(SteLivraison steLivraison){return steLivraisonRepository.save(steLivraison);}
    public void delete(Long id){
        SteLivraison steLivraison= steLivraisonRepository.findById(id).get();
        steLivraisonRepository.delete(steLivraison);
    }
    public SteLivraison getSteLivraisonById(Long id){
        return steLivraisonRepository.findById(id).get();
    }
    public List<SteLivraison> getAllSteLivraison(){
        return  steLivraisonRepository.findAll();
    }


}
