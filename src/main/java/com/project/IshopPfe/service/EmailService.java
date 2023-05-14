package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.dto.CommandeDto;
import com.project.IshopPfe.entities.Coupon;
import com.project.IshopPfe.entities.Produit;
import com.project.IshopPfe.entities.SteLivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailService {


    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }

}
