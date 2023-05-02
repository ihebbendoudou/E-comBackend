package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.CategoryRepository;
import com.project.IshopPfe.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category CreateCategory (Category category){
        return categoryRepository.save(category);
    }
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category updateCategoryById(Long id , Category category){
            Category category1 = categoryRepository.findById(id).get();
            category1.setNomCategory(category.getNomCategory());
            return categoryRepository.save(category1);
    }

    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }


    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
