package com.project.IshopPfe.Controller;

import com.project.IshopPfe.entities.SteLivraison;
import com.project.IshopPfe.service.SteLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/stelivraison")
public class SteLivraisonController {
    @Autowired SteLivraisonService service;

    @GetMapping(value = "/getAllSteLivraison")
    List<SteLivraison> getAllSteLivraison(){
        return service.getAllSteLivraison();
    }
    @PostMapping(value = "/create")
    public SteLivraison create(@RequestBody SteLivraison steLivraison){
        return service.create(steLivraison);
    }
    @PostMapping(value = "/update")
    public SteLivraison update(@RequestBody SteLivraison steLivraison){return service.update(steLivraison);}
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
    @GetMapping(value = "/getSteLivraisonById/{id}")
    public SteLivraison getSteLivraisonById(@PathVariable Long id){
        return service.getSteLivraisonById(id);
    }


    }
