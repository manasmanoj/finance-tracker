package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.Transaction;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public List<Transaction> getTransactionsByUser(User user) {
        return transactionRepository.findByUser(user);
    }

    public List<Transaction> getTransactionsBetweenDates(User user, LocalDate start, LocalDate end) {
        return transactionRepository.findByUserAndDateBetween(user, start, end);
    }
}
