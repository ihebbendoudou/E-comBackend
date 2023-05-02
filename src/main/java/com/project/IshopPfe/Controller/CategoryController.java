package com.project.IshopPfe.Controller;

import com.project.IshopPfe.entities.Category;
import com.project.IshopPfe.entities.Internaute;
import com.project.IshopPfe.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping(value = "/getCategoryByID")
    public Category getCategoryById(@PathVariable Long id){
        return service.getCategoryById(id);
    }
    @GetMapping(value = "/getAllCategory")
    public List<Category> getAll() {
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
    @PostMapping(value = "createCategory")
    public Category CreateCategory (@RequestBody Category category) {
      return   service.CreateCategory(category);
    }

}


