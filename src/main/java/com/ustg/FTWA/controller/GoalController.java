package com.ustg.FTWA.controller;

import com.ustg.FTWA.entity.Goal;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.repository.UserRepository;
import com.ustg.FTWA.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoalService goalService;

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return goalService.saveGoal(goal);
    }

    @GetMapping("/user/{userId}")
    public List<Goal> getGoalsByUser(@PathVariable String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return goalService.getGoalsByUser(user);
    }

    @GetMapping("/{id}")
    public Goal getGoalById(@PathVariable Long id) {
        return goalService.getGoalById(id).orElseThrow(() -> new RuntimeException("Goal not found"));
    }

    @PutMapping("/{id}")
    public Goal updateGoal(@PathVariable Long id, @RequestBody Goal goal) {
        return goalService.updateGoal(id, goal);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id);
    }

    @PutMapping("add-amount/{goalId}")
    public Goal addAmountToGoal(
            @PathVariable("goalId") Long goalId,
            @RequestParam(name = "amountToAdd") BigDecimal amountToAdd) {
        Goal updatedGoal = goalService.updateCurrentAmount(goalId, amountToAdd);
        return updatedGoal;
    }

    @GetMapping
    public List<Goal> getAll() {
        return goalService.getAll();
    }
}
