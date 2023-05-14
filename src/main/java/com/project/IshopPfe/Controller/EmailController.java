package com.project.IshopPfe.Controller;

import com.project.IshopPfe.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/email")
public class EmailController {
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping(value = "/send")
    public String sendEmail() {
        String to = "ihebbendoudou@gmail.com";
        String subject = "Test Email";
        String text = "el teeey bnin ";

        emailService.sendEmail(to, subject, text);
        return "Email sent successfully";
    }
}
