package com.ustg.FTWA.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ustg.FTWA.repository.TransactionRepo;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private TransactionRepo transactionRepository;

    @GetMapping("/monthly-expenses")
    public ResponseEntity<List<Map<String, Object>>> getMonthlyReport(
            @RequestParam String username,
            @RequestParam int month,
            @RequestParam int year) {

        List<Object[]> rawData = transactionRepository.getMonthlyExpensesByCategory(username, month, year);
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : rawData) {
            Map<String, Object> map = new HashMap<>();
            map.put("category", row[0]);
            map.put("total", row[1]);
            result.add(map);
        }

        return ResponseEntity.ok(result);
    }
}
