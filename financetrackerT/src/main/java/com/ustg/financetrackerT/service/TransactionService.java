package com.ustg.financetrackerT.service;

import com.ustg.financetrackerT.entity.Transaction;
import com.ustg.financetrackerT.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    public Transaction getTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepo.findById(id);
        return transaction.orElse(null);
    }

    public Transaction updateTransaction(Long id, Transaction newTransactionData) {
        return transactionRepo.findById(id).map(existing -> {
            existing.setUser(newTransactionData.getUser());
            existing.setAmount(newTransactionData.getAmount());
            existing.setCategory_id(newTransactionData.getCategory_id());
            existing.setDate(newTransactionData.getDate());
            existing.setDescription(newTransactionData.getDescription());
            existing.setType(newTransactionData.getType());
            return transactionRepo.save(existing);
        }).orElse(null);
    }

    public void deleteTransaction(Long id) {
        transactionRepo.deleteById(id);
    }
}
