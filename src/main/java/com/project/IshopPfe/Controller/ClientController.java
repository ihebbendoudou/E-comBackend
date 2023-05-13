package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/client")
public class ClientController {
    @Autowired
    ClientRepository ClRepo;
    @GetMapping(value = "/getClientById/{id}")
    public Client getClientByID(@PathVariable Long id){
        return ClRepo.findById(id).get();
    }
}
