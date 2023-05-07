//package com.project.IshopPfe.Controller;
//
//import com.project.IshopPfe.dto.AnnonceRequest;
//import com.project.IshopPfe.service.AnnonceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
////@RequestMapping(value = "api/annonce")
//@Configuration
//public class AnnonceController {
//
//    @Autowired
//    AnnonceService service;
//
//    @PostMapping(value = "api/annonce/create")
//    public Annonce create(@RequestBody AnnonceRequest request){
//        return service.CreateAnnonce(request);
//    }
//
//    @GetMapping(value = "api/annonce/getAll")
//    public List<Annonce>getAll(){
//        return service.getAll();
//    }
//    @GetMapping(value = "welcome")
//    public Annonce welcome(){return service.getAnnonceById(1L);}
//
//
//
//}
