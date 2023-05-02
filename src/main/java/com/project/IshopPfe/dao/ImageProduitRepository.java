package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.ImageProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ImageProduitRepo")
public interface ImageProduitRepository extends JpaRepository <ImageProduit,Long>{

    public List<ImageProduit> findByProduit_id(Long id);
}
