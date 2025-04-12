package com.ustg.FTWA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.entity.CategoryType;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUsernameAndType(String username, CategoryType type);
}
