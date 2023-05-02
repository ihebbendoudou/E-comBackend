package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "CategoryRepo")
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
