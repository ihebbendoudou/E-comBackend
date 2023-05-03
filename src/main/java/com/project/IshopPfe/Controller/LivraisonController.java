package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dto.LivraisonRequest;
import com.project.IshopPfe.entities.Livraison;
import com.project.IshopPfe.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/livraison")
public class LivraisonController {
    @Autowired
    LivraisonService livraisonService;

    // create
    public Livraison create (@RequestBody LivraisonRequest p){
        return livraisonService.create(p);
    }
// update
public Livraison update (@RequestBody LivraisonRequest p){
    return livraisonService.update(p);
}
// delete
public void delete (@PathVariable Long id){
        livraisonService.delete(id);
}
// getLivraisonById
    public Livraison getLivraisonById(@PathVariable Long id){
        return livraisonService.getLivraisonById(id);
    }
// getAllLivraison
public List<Livraison> getLivraison(){
    return livraisonService.getLivraison();
}
public List<Livraison> getBySteLivraisonId(@PathVariable Long id){
        return livraisonService.getBySteLivraisonId(id);
}
}
