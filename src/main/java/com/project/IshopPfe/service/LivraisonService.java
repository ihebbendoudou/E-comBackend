package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.LivraisonRepository;
import com.project.IshopPfe.dao.SteLivraisonRepository;
import com.project.IshopPfe.dto.LivraisonRequest;
import com.project.IshopPfe.entities.Livraison;
import com.project.IshopPfe.entities.SteLivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivraisonService {
    @Autowired LivraisonRepository repo;
    @Autowired
    SteLivraisonRepository steRepo;
    // create
    public Livraison create (LivraisonRequest p){
        SteLivraison steLivraisonService=  steRepo.findById(p.ste_livraison_id).get();
        Livraison l= new Livraison(p.dateLivraison,p.solde,steLivraisonService);
        return repo.save(l);
    }
        // update
        public Livraison update (LivraisonRequest p){
            SteLivraison steLivraisonService=  steRepo.findById(p.ste_livraison_id).get();
            Livraison l= new Livraison(p.dateLivraison,p.solde,steLivraisonService);
            return repo.save(l);
        }
        // delete
        public void delete (Long id){
            Livraison l = repo.findById(id).get();
            repo.delete(l);
            }
        // getLivraisonById
            public Livraison getLivraisonById(Long id){
                return repo.findById(id).get();
            }
        // getAllLivraison
        public List<Livraison> getLivraison(){
            return repo.findAll();
        }
        public  List<Livraison> getBySteLivraisonId(Long id){
            return repo.findBySteLivraisonId(id);
        }


}
