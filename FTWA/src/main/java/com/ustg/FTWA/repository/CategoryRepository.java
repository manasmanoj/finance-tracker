package com.ustg.FTWA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.entity.Category.CategoryType;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByType(CategoryType type);
}
