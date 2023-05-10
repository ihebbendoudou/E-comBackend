package com.project.IshopPfe;

import com.project.IshopPfe.dto.AnnonceRequest;
import com.project.IshopPfe.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.project.IshopPfe")
@SpringBootApplication
@EnableJpaRepositories
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);



    }
}