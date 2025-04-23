package com.ustg.financeTracker2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ustg.financeTracker2.entity.Goal;
import com.ustg.financeTracker2.service.GoalService;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping("/user/{userId}")
    public Goal getGoals(@PathVariable Long userId) {
        return goalService.getUserGoals(userId);
    }

    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        return ResponseEntity.ok(goalService.createGoal(goal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Long id, @RequestBody Goal goal) {
        return ResponseEntity.ok(goalService.updateGoal(id, goal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public Goal getGoals1(@PathVariable Long Id) {
        return goalService.getUserGoals(Id);
    }
    
    @GetMapping
    public List<Goal> getAll(){
    	return goalService.getAllUsers();
    }
}
