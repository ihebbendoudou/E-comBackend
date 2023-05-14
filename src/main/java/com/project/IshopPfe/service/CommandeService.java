package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.dto.CommandeDto;
import com.project.IshopPfe.dto.MailCorp;
import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.entities.Coupon;
import com.project.IshopPfe.entities.Produit;
import com.project.IshopPfe.entities.SteLivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommandeService {
    @Autowired
    CouponService couponService;
    @Autowired
    ProduitService produitService;
    @Autowired
    SteLivraisonService steLivraisonService;
    @Autowired
    EmailService emailService;

    public void create(CommandeDto commandeDto){
        Coupon c = (Coupon) couponService.couponRepository.
                findByValue(commandeDto.coupon);
        Produit p = produitService.getProduit(commandeDto.idProd);
        if(c!=null){
            p.setPrix(p.getPrix()-((p.getPrix()*c.getPourcentage())/100));
        }
        SteLivraison ste= steLivraisonService.getSteLivraisonById(commandeDto.idStl);
        String text=" hello " + ste.getIntitule()+ "\n"+
                " je vous informe que notre client : '"+commandeDto.prenom +" "+commandeDto.prenom +"" +
                " a passe une commande le "+ new Date() +" composer de : \n"+
                "titre produit : "+p.getLabelle()+
                "prix : "+p.getPrix()+
                "Client Info : \n "+
                "Email : "+commandeDto.email+
                "tel : "+ commandeDto.tel+
                "adresse: "+commandeDto.adresse;
        emailService.sendEmail(ste.getEmail(), "new commande", text);
    }
}
