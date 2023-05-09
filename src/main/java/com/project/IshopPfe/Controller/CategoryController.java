package com.project.IshopPfe.Controller;

import com.project.IshopPfe.entities.Category;
import com.project.IshopPfe.entities.Internaute;
import com.project.IshopPfe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "api/category")
public class CategoryController {

    @Autowired CategoryService service;

    @GetMapping(value = "/getCategoryByID/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return service.getCategoryById(id);
    }
    @GetMapping(value = "/getAllcategory")
    public List<Category> getAllcategory() {
        return service.getAllCategory();
    }
    @PutMapping(value = "/updateCategoryByID/{id}")
    public Category updateCategoryById(@PathVariable Long id, @RequestBody Category category) {
        return service.updateCategoryById(id, category);
    }
    @PutMapping(value = "/updateCategory")
    public Category updateCategory(@RequestBody Category category) {
        return service.updateCategory(category);
    }

    @DeleteMapping(value = "/deleteCategoryById/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        service.deleteCategoryById(id);
    }

    @DeleteMapping(value = "/delete")
    public void deleteCategory(@RequestBody Category category) {
        service.deleteCategory(category);
    }
    @PostMapping(value = "/createCategory")
    public Category CreateCategory (@RequestBody Category category) {
      return   service.CreateCategory(category);
    }

}


