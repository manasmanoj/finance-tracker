package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.SpendLimit;
import com.ustg.FTWA.entity.Transaction;
import com.ustg.FTWA.repository.NotificationsRepository;
import com.ustg.FTWA.repository.SpendLimitRepository;
import com.ustg.FTWA.repository.TransactionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepository;
    
    @Autowired
    private SpendLimitRepository spendLimitRepository;

    @Autowired
    private NotificationsRepository notificationRepository;
    
    public Transaction addTransaction(Transaction transaction) {
        // Save transaction
        Transaction saved = transactionRepository.save(transaction);

        // Check if spend limit exceeded
        if (transaction.getType() ==transactionType.EXPENSE) {
            Double totalSpent = transactionRepository.getTotalExpensesByUsername(transaction.getUsername());
            SpendLimit limit = spendLimitRepository.findByUsername(transaction.getUsername());

            if (limit != null && totalSpent > limit.getLimitAmount()) {
                Notification notification = new Notification();
                notification.setUsername(transaction.getUsername());
                notification.setMessage("You have exceeded your spend limit!");
                notification.setType(NotificationType.LIMIT_ALERT);
                notification.setCreatedAt(LocalDateTime.now());
                notification.setIsRead(false);

                notificationRepository.save(notification);
            }
        }

        return saved;
    }

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
