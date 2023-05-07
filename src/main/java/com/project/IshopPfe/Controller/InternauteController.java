package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dto.CreateInternauteRequest;
import com.project.IshopPfe.entities.Internaute;
import com.project.IshopPfe.service.InternautService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/internaute")
public class InternauteController {
    private final InternautService service;
    public InternauteController(InternautService service) {
        this.service = service;
    }
    @GetMapping(value = "/")
    public String welcome(){
        return "welcome";
    }
    @GetMapping(value = "/getAllInternaute")
    public List <Internaute> getAll(){
        return service.getAll();
    }
    @GetMapping(value = "/getInternabyteById/{id}")
    public Internaute getInternauteByID(@PathVariable Long id){
        return service.getInternauteById(id);
    }
    @PostMapping(value = "/createInternaute")
        public Internaute createInternaute(@RequestBody CreateInternauteRequest request) {
        return service.save(request);

    }
    @DeleteMapping (value = "/deleteInternauteByID")
        public void deleteInternauteByID(@PathVariable Long id){
         service.deleteInternautebyId(id);
    }
    @PutMapping(value = "/updateInternaute/{id}")
        public Internaute updateInternaute(@PathVariable Long id ,@RequestBody CreateInternauteRequest request){
        return service.updateInternaute(id,request);
    }
   @PostMapping(value = "/loginInternaute")
   public boolean login(@RequestBody CreateInternauteRequest request){
    return service.LoginInternaute(request.getEmail(),request.getPassword());
    }
    }

