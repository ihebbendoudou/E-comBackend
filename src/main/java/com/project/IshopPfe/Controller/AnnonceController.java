package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dto.AnnonceRequest;
import com.project.IshopPfe.entities.Annonce;
import com.project.IshopPfe.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/annonce")
public class AnnonceController {

    @Autowired
    AnnonceService service;

    @PostMapping("/annonces")
    public ResponseEntity<Annonce> createAnnonce(@RequestBody AnnonceRequest request) {
        Annonce ii = service.CreateAnnonce(request);
        return ResponseEntity.ok(ii);
    }


    @PutMapping(value = "/updateAnnonce/{id}")
    public Annonce updateAnn(@PathVariable long id, @RequestBody AnnonceRequest ann) {
        return service.AnnonceUpdate(id, ann);
    }


    @GetMapping(value = "/getAllAnnonce")
    public List<Annonce> getAllAno(){
        List<Annonce> a= service.getAll();
        System.out.println(a);
        return a;
    }

    @GetMapping(value = "/getAnnoncer/{id}")
    List<Annonce>getAnnoncer(@PathVariable int idc){
        return service.getAnnoncer(idc);
    }



//    @GetMapping(value = "api/annonce/getAll")
//    public List<Annonce>getAll(){
//        return service.getAll();
//    }
//    @GetMapping(value = "welcome")
//    public Annonce welcome(){return service.getAnnonceById(1L);}



}
