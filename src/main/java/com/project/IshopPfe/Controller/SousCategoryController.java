package com.project.IshopPfe.Controller;
import com.project.IshopPfe.dto.SousCategoryRequest;
import com.project.IshopPfe.entities.sous_category;
import com.project.IshopPfe.service.SousCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "api/SousCategory")
public class SousCategoryController {
    private final SousCategoryService service;

    public SousCategoryController(SousCategoryService service) {
        this.service = service;
    }

    @GetMapping(value = "/getSousCategoryByCategoryID/{id}")
    public List<sous_category> getSousCategoryByCategoryID(@PathVariable Long id) {
        return service.findByCategory(id);
    }
    @GetMapping(value = "/getAllSousCategory")
    public List<sous_category> getAllSousCategory(){
        return service.getAllSousCategory();
    }
    @PostMapping(value = "/createSousCategory")
    public sous_category createSousCategory(@RequestBody SousCategoryRequest request){
        return service.createSousCategory(request);
    }
    @GetMapping(value = "/getSousCategoryById/{id}")
    sous_category getSousCategoryById(@PathVariable Long id){
        return service.getSousCategoryById(id);
    }
    @GetMapping(value = "/getSousCategoryByNom/{nom}")
    sous_category getSousCategoryByNom(@PathVariable String nom){
       return service.findSousCategorybyNom(nom);
    }
    @GetMapping(value = "/getSousCategoryByCategoryIddd/{id}")
    List <sous_category> getSousCategoryByCategoryId(@PathVariable Long id){
        return service.getSousCategoryByCategoryIddd(id);
    }

    @DeleteMapping("value = /deleteSousCategory")

    void deleteSousCategory(@RequestBody sous_category sc){
        service.deleteSousCategory(sc);
    }
    @GetMapping(value = "/delete/{id}")
    String msg(@PathVariable Long id){
       if( service.deleteSousCategoryByid(id)==true){
           return "tfaskhet";
       }else
           return "ma tfaskhtesh";
    }

}