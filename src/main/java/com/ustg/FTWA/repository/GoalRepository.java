package com.ustg.FTWA.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.entity.Goal;
import com.ustg.FTWA.entity.User;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUser(User userId);

    Optional<Goal> findByUserAndCategory(User user, Category category);
}
