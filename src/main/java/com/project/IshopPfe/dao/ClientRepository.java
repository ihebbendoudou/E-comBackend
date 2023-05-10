package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.entities.Internaute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("select c from client c where c.email = ?1 and c.password = ?2")
    public Client findByEmailAndPassword(String email, String password);
}
