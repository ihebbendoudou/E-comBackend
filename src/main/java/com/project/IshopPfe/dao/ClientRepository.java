package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
