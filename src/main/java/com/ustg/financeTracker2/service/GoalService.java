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

    public Goal getUserGoals(Long userId) {
        return goalRepo.findByUserId(userId);
    }

    public Goal createGoal(Goal goal) {
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
    
    public Goal getUserGoals1(Long Id) {
        return goalRepo.findByUserId(Id);
    }
    
    public List<Goal> getAllUsers(){
    	return goalRepo.findAll();
    }
}
