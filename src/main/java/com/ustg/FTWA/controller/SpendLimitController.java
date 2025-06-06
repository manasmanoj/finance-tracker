package com.ustg.FTWA.controller;

import com.ustg.FTWA.entity.SpendLimit;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.service.SpendLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spendlimits")
public class SpendLimitController {

    @Autowired
    private SpendLimitService spendLimitService;

    @PostMapping
    public SpendLimit createSpendLimit(@RequestBody SpendLimit spendLimit) {
        return spendLimitService.createSpendLimit(spendLimit);
    }

    @GetMapping("/user/{userId}")
    public List<SpendLimit> getSpendLimitsByUser(@PathVariable String userId) {
        User user = new User();
        user.setUsername(userId); // assuming String ID
        return spendLimitService.getSpendLimitsByUser(user);
    }

    @GetMapping("/user/{userId}/active")
    public List<SpendLimit> getActiveSpendLimits(@PathVariable String userId) {
        User user = new User();
        user.setUsername(userId);
        return spendLimitService.getActiveSpendLimits(user);
    }

    @GetMapping("/user/{userId}/category/{categoryId}")
    public List<SpendLimit> getSpendLimitsByUserAndCategory(
            @PathVariable String userId,
            @PathVariable Long categoryId) {
        User user = new User();
        user.setUsername(userId);
        Category category = new Category();
        category.setId(categoryId);
        return spendLimitService.getSpendLimitsByUserAndCategory(user, category);
    }

    @GetMapping("/check-alert/{spendLimitId}")
    public ResponseEntity<String> checkAlert(@PathVariable Long spendLimitId) {
        boolean alertExceeded = spendLimitService.checkAlertThreshold(spendLimitId);

        if (alertExceeded) {
            return ResponseEntity.status(HttpStatus.OK).body("Alert: Spend limit exceeded!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Spend limit is within threshold.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpendLimit(@PathVariable Long id) {
        spendLimitService.deleteSpendLimit(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public List<SpendLimit> getAllSpendLimits() {
        return spendLimitService.getAllSpendLimits();
    }

}
