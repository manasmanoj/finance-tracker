package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.entity.Category.CategoryType;
import com.ustg.FTWA.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getCategoriesByType(CategoryType type) {
        return categoryRepository.findByType(type);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
