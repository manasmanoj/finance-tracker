package com.ustg.category.repository;

import com.ustg.category.entity.Category;
import com.ustg.category.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUsernameAndType(String username, CategoryType type);
}
