package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dto.ClientDto;
import com.project.IshopPfe.dto.CommandeDto;
import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.service.CommandeService;
import com.project.IshopPfe.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/commande")
public class CommandeController {
@Autowired
    CommandeService service;
@Autowired
EmailService emailService;

    @PostMapping(value = "/create")
    String create(@RequestBody CommandeDto commandeDto){
        service.create(commandeDto);
        return "Email sent successfully";
    }
}
