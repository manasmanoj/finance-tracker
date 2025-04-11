package com.ustg.financeTracker2.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustg.financeTracker2.entity.Goal;
import com.ustg.financeTracker2.repository.GoalRepository;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepo;

    public List<Goal> getUserGoals(Long userId) {
        return goalRepo.findByUserId(userId);
    }

    public Goal createGoal(Goal goal) {
        goal.setCreatedAt(LocalDate.now());
        goal.setCurrentAmount(BigDecimal.ZERO); // initial
        return goalRepo.save(goal);
    }

    public Goal updateGoal(Long id, Goal updated) {
        Goal goal = goalRepo.findById(id).orElseThrow();
        goal.setTitle(updated.getTitle());
        goal.setTargetAmount(updated.getTargetAmount());
        if (updated.getCurrentAmount() != null) {
            goal.setCurrentAmount(updated.getCurrentAmount());
        }
        goal.setDeadline(updated.getDeadline());
        return goalRepo.save(goal);
    }

    public void deleteGoal(Long id) {
        goalRepo.deleteById(id);
    }
}
