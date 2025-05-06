package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.Goal;

import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private NotificationsService notificationsService;

    @Autowired
    private GoalRepository goalRepository;

    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> getGoalsByUser(User user) {
        return goalRepository.findByUser(user);
    }

    public Optional<Goal> getGoalById(Long id) {
        return goalRepository.findById(id);
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }

    public Goal updateGoal(Long id, Goal updatedGoal) {
        return goalRepository.findById(id).map(goal -> {
            goal.setTitle(updatedGoal.getTitle());
            goal.setTargetAmount(updatedGoal.getTargetAmount());
            goal.setCurrentAmount(updatedGoal.getCurrentAmount());
            goal.setDeadline(updatedGoal.getDeadline());

            return goalRepository.save(goal);
        }).orElseThrow(() -> new RuntimeException("Goal not found"));
    }

    public Goal updateCurrentAmount(Long goalId, BigDecimal amountToAdd) {
        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new RuntimeException("Goal not found"));

        // Update the amount
        BigDecimal updatedAmount = goal.getCurrentAmount().add(amountToAdd);
        goal.setCurrentAmount(updatedAmount);

        Goal updatedGoal = goalRepository.save(goal);

        // Send notification 🚀
        String message = String.format(
                "💰 You've updated your goal '%s'. Saved ₹%,.2f of ₹%,.2f!",
                updatedGoal.getTitle(), updatedGoal.getCurrentAmount(), updatedGoal.getTargetAmount());

        notificationsService.sendNotification(updatedGoal.getUser(), message, updatedGoal);

        return updatedGoal;
    }

    public List<Goal> getAll() {
        return goalRepository.findAll();
    }
}
