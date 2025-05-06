package com.ustg.FTWA.controller;

import com.ustg.FTWA.entity.Bank;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping
    public Bank saveTransaction(@RequestBody Bank bank) {
        return bankService.saveBankTransaction(bank);
    }

    @GetMapping
    public List<Bank> getAllTransactions() {
        return bankService.getAllTransactions();
    }

    @GetMapping("/user/{userId}")
    public List<Bank> getTransactionsByUser(@PathVariable String userId) {
        User user = new User();
        user.setUsername(userId);
        return bankService.getTransactionsByUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        bankService.deleteTransaction(id);
    }

    @GetMapping("/{id}")
    public Bank getTransactionById(@PathVariable Long id) {
        return bankService.getTransactionById(id);
    }
}
