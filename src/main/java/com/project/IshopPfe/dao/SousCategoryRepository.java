package com.project.IshopPfe.dao;

import com.project.IshopPfe.dto.SousCategoryRequest;
import com.project.IshopPfe.entities.sous_category;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "SousCategoryRepo")
public interface SousCategoryRepository extends JpaRepository<sous_category, Long> {

        @Query("select s from sous_category s where s.category.id = ?1")
        List<sous_category> findByCategory_id(Long id);
        @Query("select s from sous_category s where s.nom_sous_category = ?1")
        sous_category findBynom_sous_category(String st);
        @Transactional
        @Modifying
        @Query("delete from sous_category s where s.id = ?1")
        void deleteById(Long id);

        @Query("select  new com.project.IshopPfe.entities.sous_category(d.id, d.nom_sous_category) from sous_category d where d.category.id = ?1")
        List<sous_category> getSousCategoryByCategoryIddd(Long id);
}
