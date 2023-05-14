package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.dto.ClientDto;
import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.entities.Internaute;
import com.project.IshopPfe.entities.Magasin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/client")
public class ClientController {
    @Autowired
    ClientRepository ClRepo;
    @GetMapping(value = "/getClientById/{id}")
    public ClientDto getClientByID(@PathVariable Long id){
         Client c=ClRepo.findById(id).get();
        ClientDto d=new ClientDto();
         if (c instanceof Magasin){

            d.id=c.getId();
            d.Owner=((Magasin) c).getIntitule();
            d.adresse=((Magasin) c).getAdresse();
            d.email=c.getEmail();
            d.tel=c.getTel();

        }else if (c instanceof Internaute){

             d.id=c.getId();
             d.Owner=((Internaute) c).getNom()+" "+((Internaute) c).getPrenom();
             d.adresse=((Magasin) c).getAdresse();
             d.email=c.getEmail();
             d.tel=c.getTel();
         }
         return d;
    }
}
