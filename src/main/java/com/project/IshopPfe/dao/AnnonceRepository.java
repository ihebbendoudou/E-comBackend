package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Annonce;
import com.project.IshopPfe.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
//    @Query("select a from annonce a where a.client.id = ?1")
//    List<Annonce> findByClientId(long id);
    @Query("select a from annonce a where a.produit.id = ?1")
    Annonce findByProduitId(long id);

        @Query("select a from annonce a where a.idC = ?1")
        List<Annonce> findByIdC(int idc);
    @Query("select a from annonce a order by a.dateCreation DESC")
    List<Annonce> findAllByOrderByDateCreationDesc();
    @Query("select a from annonce a where a.produit.prix between ?1 and ?2")
    List<Annonce> findAllByProduit_PrixBetween(double v1, double v2);
    @Query("select a from annonce a where a.produit.sousCategory.id = ?1")
    List<Annonce>findAllByProduit_SousCategory(Long v1);
    @Query("select a from annonce a where a.produit.sousCategory.category.id = ?1")
    List<Annonce>findAllByProduit_SousCategory_Category_Id(Long v1);

}
