package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.entity.Goal;
import com.ustg.FTWA.entity.Transaction;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.repository.CategoryRepository;
import com.ustg.FTWA.repository.GoalRepository;
import com.ustg.FTWA.repository.TransactionRepository;
import com.ustg.FTWA.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private GoalRepository goalRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction saveTransaction(Transaction transaction) {
        Long categoryId = transaction.getCategory().getId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        transaction.setCategory(category);

        // Handle User
        String userId = transaction.getUser().getUsername();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        transaction.setUser(user);
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

    public List<Transaction> getAllTransactionsForUser(String username) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return transactionRepository.findByUser(user);

    }

    @Transactional
    public Transaction SaveTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Get the user and category from transaction
        User user = transaction.getUser();
        Category category = transaction.getCategory();

        // Find matching goal for this user and category
        Optional<Goal> matchingGoal = goalRepository.findByUserAndCategory(user, category);

        if (matchingGoal.isPresent()) {
            Goal goal = matchingGoal.get();
            goal.setCurrentAmount(goal.getCurrentAmount().add(transaction.getAmount()));
            goalRepository.save(goal);
        }

        return savedTransaction;
    }

}
