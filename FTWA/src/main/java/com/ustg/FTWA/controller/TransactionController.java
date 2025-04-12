package com.ustg.FTWA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ustg.FTWA.entity.Transaction;
import com.ustg.FTWA.service.TransactionService;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionServices;

    @PostMapping
    public Transaction add(@RequestBody Transaction transaction) {
        return transactionServices.createTransaction(transaction);
    }

    @GetMapping("/{id}")
    public Transaction transactionId(@PathVariable Long id) {
        return transactionServices.getTransactionById(id);
    }

    @GetMapping
    public List<Transaction> allTransactions() {
        return transactionServices.getAllTransactions();
    }

    @PutMapping("/{id}")
    public Transaction Update(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionServices.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteByTransactionId(@PathVariable Long id) {
        transactionServices.deleteTransaction(id);
    }

}
