package com.ustg.FTWA.controller;

import com.ustg.FTWA.entity.SpendLimit;
import com.ustg.FTWA.service.SpendLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spend-limits")

public class SpendLimitController {
	@Autowired
    private SpendLimitService spendLimitService;

    @PostMapping
    public ResponseEntity<SpendLimit> createSpendLimit(@RequestBody SpendLimit spendLimit) {
        return ResponseEntity.ok(spendLimitService.saveSpendLimit(spendLimit));
    }

    @GetMapping
    public ResponseEntity<List<SpendLimit>> getAllSpendLimits() {
        return ResponseEntity.ok(spendLimitService.getAllSpendLimits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpendLimit> getSpendLimitById(@PathVariable Long id) {
        return spendLimitService.getSpendLimitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<SpendLimit>> getSpendLimitsByUsername(@PathVariable String username) {
        return ResponseEntity.ok(spendLimitService.getSpendLimitsByUsername(username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpendLimit(@PathVariable Long id) {
        spendLimitService.deleteSpendLimit(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpendLimit> updateSpendLimit(@PathVariable Long id, @RequestBody SpendLimit updatedLimit) {
        return spendLimitService.getSpendLimitById(id)
                .map(existingLimit -> {
                    updatedLimit.setId(id);
                    return ResponseEntity.ok(spendLimitService.saveSpendLimit(updatedLimit));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
