package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dto.CommandeDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/commande")
public class CommandeController {


    @PostMapping(value = "/create")
    String create(@RequestBody CommandeDto commandeDto){
        return "c bon";
    }
}
