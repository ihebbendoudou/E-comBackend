package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "produitRepo")
public interface ProduitRepository extends CrudRepository<Produit,Long> {

       @Query("select p from produit p where p.labelle = ?1")
       public Produit findByLabelle(String nom);
}
