package com.project.IshopPfe;

import com.project.IshopPfe.dto.CreateInternauteRequest;
import com.project.IshopPfe.entities.Internaute;
import com.project.IshopPfe.service.InternautService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@SpringBootApplication
@EnableJpaRepositories
public class ProductApplication  implements CommandLineRunner {
    @Autowired(required=true)
   private final InternautService service;

    public ProductApplication(InternautService service) {
        this.service = service;
    }


    public static void main(String[] args) {

        SpringApplication.run(ProductApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
      // CreateInternauteRequest internaute= new CreateInternauteRequest(5215L,"pass","iheb","iheb@iheb","ali","lazher");
      // service.save(internaute);
    }
}
