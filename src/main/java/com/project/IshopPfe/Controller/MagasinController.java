package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dto.CreateInternauteRequest;
import com.project.IshopPfe.dto.CreateMagasinRequest;
import com.project.IshopPfe.entities.Internaute;
import com.project.IshopPfe.entities.Magasin;
import com.project.IshopPfe.service.MagasinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/magasin")
public class MagasinController {
    private final MagasinService service;

    public MagasinController(MagasinService service) {
        this.service = service;
    }
    @GetMapping(value = "/")
    public String welcome(){
        return "welcome";
    }
    @GetMapping(value = "/getAllMagasin")
    public List <Magasin> getAll(){
        return service.getAll();
    }
    @GetMapping(value = "/getIMagasinById/{id}")
    public Magasin getMagasinByID(@PathVariable Long id){
        return service.getMagasibnById(id);
    }
    @PostMapping(value = "/createInternaute")
        public Magasin createInternaute(@RequestBody CreateMagasinRequest request) {
        return service.save(request);

    }
    @DeleteMapping (value = "/deleteMagasinByID")
        public void deleteMagasinByID(@PathVariable Long id){
         service.deleteMagasinbyId(id);
    }
    @PutMapping(value = "/updateMagasin/{id}")
        public Magasin updateMagasin(@PathVariable Long id ,@RequestBody CreateMagasinRequest request){
        return service.updateMagasin(id,request);
    }
   @PostMapping(value = "/loginMagasin/")
   public boolean login(@RequestBody CreateMagasinRequest request){
    return service.LoginMagasin(request.getEmail(),request.getPassword());
    }
    }

