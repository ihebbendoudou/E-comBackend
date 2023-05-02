package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dto.ProduitRequest;
import com.project.IshopPfe.entities.Produit;
import com.project.IshopPfe.service.ProduitService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/produit")
public class ProduitController {

    @Autowired ProduitService produitService;
    @GetMapping(value = "/getAllProduit")
    public List<Produit> getAllProduit(){
        return produitService.getAllProduits();
    }
    @GetMapping(value = "/getProduit/{id}")
    public Produit getProduitById(@PathVariable Long id){
        return produitService.getProduit(id);
    }
    @PutMapping (value = "/udpate")
    public Produit udpate(@RequestBody ProduitRequest request){
        return produitService.updateProduit(request);
    }
    @DeleteMapping (value = "/delete/{id}")
    public  void delete(@PathVariable Long id){
         produitService.deleteProduitById(id);
    }
    @GetMapping(value = "/getProduitByNom/{nom}")
    public Produit getProduitByNom(@PathVariable String  nom){
        return produitService.getProduitByNom(nom);
    }


}
