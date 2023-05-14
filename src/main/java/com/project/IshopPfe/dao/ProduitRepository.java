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


    @Query("select p from produit p where p.statut = ?1 and p.client.id = ?2")
    List<Produit> findByStatutAndClientId(int statut, long id);

    @Query("select p from produit p where p.client.id = ?1 and p.statut = ?2")
    List<Produit> findByClientIdAndStatut(long id, int statut);
    @Query("select p from produit p where p.client.id = ?1 and p.statut = ?2")
    List<Produit> findByClientIdAndStatut1(long id, int statut);
    public Long countByClientId(Long id);
    @Query("select count(p) from produit p where p.client.id = ?1 and p.statut = ?2")
    public Long countByClientIdAndStaut(Long id,int c);

    @Query("select p from produit p where p.client.id = ?1")
    List<Produit> findByClientId(Long id);
    @Query("select p from produit p where p.statut = ?1 and p.prix between ?2 and ?3")
    List<Produit> findByStatutAndPrixBetween(int s, double v1, double v2);
    @Query("select p from produit p where p.statut = ?1 and p.sousCategory.id = ?2")
    List<Produit>findByStatutAndSousCategory(int s, int v1);
    @Query("select p from produit p where p.statut = ?1 and p.sousCategory.category.id = ?2")
    List<Produit> findByStatutAndSousCategory_Category_Id(Long categoryId);
}
