package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.ParameterOutOfBoundsException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "produitRepo")
public interface ProduitRepository extends CrudRepository<Produit,Long> {

    public Produit findFirstByOrderByIdDesc();

    @Query("select p from produit p where p.labelle = ?1")
       public Produit findByLabelle(String nom);
//
//    @Query(value = "select DISTINCT p.* from produit p , annonce a" +
//            "WHERE p.id not in (select a.id from annonce a) " +
//            "and p.client_id= :clientId"
//            , nativeQuery = true)
//    List<Produit> getProdNonAnnonce(@Param("clientId") Long clientId);
//
    @Query(value = "SELECT p.* FROM produit p WHERE p.statut=0 and p.client_id=?1",nativeQuery = true)
    List<Produit>  getbyStatut(Long idClient);
}
