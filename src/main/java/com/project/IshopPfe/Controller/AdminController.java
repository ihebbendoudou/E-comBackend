package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dao.AdminRepository;
import com.project.IshopPfe.dto.CreateMagasinRequest;
import com.project.IshopPfe.dto.ProduitRequest;
import com.project.IshopPfe.entities.Admin;
import com.project.IshopPfe.entities.Produit;
import com.project.IshopPfe.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/admin")
public class AdminController {
    @Autowired
    AdminService service;
    @PostMapping(value = "/loginMagasin/")
    public boolean login(@RequestBody CreateMagasinRequest request){
        return service.LoginAdmin(request.getEmail(),request.getPassword());
    }
    @PutMapping(value = "/udpate")
    public Admin udpate(@RequestBody Admin request){
        return service.updateAdmin(request);
    }


}
