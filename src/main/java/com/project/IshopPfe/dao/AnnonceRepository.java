package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
//    @Query("select a from annonce a where a.client.id = ?1")
//    List<Annonce> findByClientId(long id);
//    @Query("select a from annonce a where a.produit.id = ?1")
//    List<Annonce> findByProduitId(long id);

        @Query("select a from annonce a where a.idC = ?1")
        List<Annonce> findByIdC(int idc);
}
