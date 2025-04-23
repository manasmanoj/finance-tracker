package com.ustg.FTWA.controller;

import com.ustg.FTWA.entity.Transaction;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }

    // Custom endpoint example: Get transactions for a user between dates
    @GetMapping("/user/{userId}/between")
    public List<Transaction> getTransactionsBetweenDates(
            @PathVariable String userId,
            @RequestParam("start") String start,
            @RequestParam("end") String end) {
        User user = new User();
        user.setUsername(userId);
        return transactionService.getTransactionsBetweenDates(
                user,
                LocalDate.parse(start),
                LocalDate.parse(end));
    }
}
