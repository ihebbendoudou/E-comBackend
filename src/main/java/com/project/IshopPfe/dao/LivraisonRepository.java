package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LivraisonRepository extends JpaRepository<Livraison,Long> {



    @Query("select l from livraison l where l.steLivraison.id = ?1")
    List<Livraison> findBySteLivraisonId(Long id);
}
