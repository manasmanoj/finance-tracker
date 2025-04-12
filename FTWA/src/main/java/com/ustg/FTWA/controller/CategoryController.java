package com.ustg.FTWA.controller;

import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.entity.CategoryType;
import com.ustg.FTWA.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin // Allow frontend calls
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @GetMapping
    public List<Category> gwtAll(){
    	return categoryRepository.findAll();
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
