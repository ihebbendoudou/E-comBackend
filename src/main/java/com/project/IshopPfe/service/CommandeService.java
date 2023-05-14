package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.dao.CouponRepository;
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
    CouponRepository couponRepository;
    @Autowired
    ProduitService produitService;
    @Autowired
    SteLivraisonService steLivraisonService;
    @Autowired
    EmailService emailService;
    public void create(CommandeDto commandeDto) {
        Coupon c = (Coupon) couponService.couponRepository.findByValue(commandeDto.coupon);
        Produit p = produitService.getProduit(commandeDto.idProd);

        if (c != null) {
            p.setPrix(p.getPrix() - ((p.getPrix() * c.getPourcentage()) / 100));
        }

        SteLivraison ste = steLivraisonService.getSteLivraisonById(commandeDto.idStl);

        String text = "Hello " + ste.getIntitule() + ",\n\n" +
                "I would like to inform you that our client, '" + commandeDto.prenom + " " + commandeDto.prenom + "'," +
                " has placed an order on " + new Date() + ". The order details are as follows:\n\n" +
                "Product Title: " + p.getLabelle() + "\n" +
                "Price: " + p.getPrix() + "\n\n" +
                "Client Information:\n" +
                "Email: " + commandeDto.email + "\n" +
                "Tel: " + commandeDto.tel + "\n" +
                "Address: " + commandeDto.adresse;

        emailService.sendEmail(ste.getEmail(), "New Order", text);
    }



}
