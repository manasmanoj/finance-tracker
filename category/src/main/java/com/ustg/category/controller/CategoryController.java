package com.ustg.category.controller;

import com.ustg.category.entity.Category;
import com.ustg.category.entity.CategoryType;
import com.ustg.category.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin // Allow frontend calls
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @GetMapping("/{username}/{type}")
    public ResponseEntity<List<Category>> getCategoriesByUsernameAndType(
            @PathVariable String username,
            @PathVariable CategoryType type) {
        return ResponseEntity.ok(categoryRepository.findByUsernameAndType(username, type));
    }
}
