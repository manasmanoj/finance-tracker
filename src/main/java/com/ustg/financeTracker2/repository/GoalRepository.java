package com.ustg.financeTracker2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.financeTracker2.entity.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
   Goal findByUserId(Long userId);
}
