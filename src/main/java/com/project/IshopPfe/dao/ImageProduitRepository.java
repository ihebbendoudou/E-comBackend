package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.ImageProduit;
import com.project.IshopPfe.entities.sous_category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ImageProduitRepo")
public interface ImageProduitRepository extends JpaRepository <ImageProduit,Long>{

   @Query("select i from imageProduit i where i.produit.id = ?1")
   public List<ImageProduit> findByProduit_id(Long id);

    @Query(value = "select s.path from image_produit s where s.produit_id = :id1" ,
           nativeQuery = true)
   public List<ImageProduit> findByProduit(@Param("id1") Long productId);

}
