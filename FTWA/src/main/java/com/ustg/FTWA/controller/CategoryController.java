package com.ustg.FTWA.controller;

import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.entity.Category.CategoryType;
import com.ustg.FTWA.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/type/{type}")
    public List<Category> getCategoriesByType(@PathVariable CategoryType type) {
        return categoryService.getCategoriesByType(type);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
}
