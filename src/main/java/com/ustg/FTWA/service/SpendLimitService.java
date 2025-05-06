package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.SpendLimit;
import com.ustg.FTWA.entity.Transaction;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.repository.SpendLimitRepository;
import com.ustg.FTWA.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class SpendLimitService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private SpendLimitRepository spendLimitRepository;

    public SpendLimit createSpendLimit(SpendLimit spendLimit) {
        return spendLimitRepository.save(spendLimit);
    }

    public List<SpendLimit> getSpendLimitsByUser(User user) {
        return spendLimitRepository.findByUser(user);
    }

    public List<SpendLimit> getSpendLimitsByUserAndCategory(User user, Category category) {
        return spendLimitRepository.findByUserAndCategory(user, category);
    }

    public List<SpendLimit> getActiveSpendLimits(User user) {
        LocalDate now = LocalDate.now();
        return spendLimitRepository.findByUserAndStartDateBeforeAndEndDateAfter(user, now, now);
    }

    public boolean checkAlertThreshold(Long spendLimitId) {

        SpendLimit spendLimit = spendLimitRepository.findById(spendLimitId)
                .orElseThrow(() -> new RuntimeException("SpendLimit not found"));

        List<Transaction> transactions = transactionRepository
                .findByUserAndCategory(spendLimit.getUser(), spendLimit.getCategory());

        double totalSpent = transactions.stream()
                .filter(transaction -> !transaction.getDate().isBefore(spendLimit.getStartDate()) &&
                        !transaction.getDate().isAfter(spendLimit.getEndDate()))
                .mapToDouble(transaction -> transaction.getAmount().doubleValue())
                .sum();

        return totalSpent >= spendLimit.getAlertThreshold();
    }

    @DeleteMapping
    public void deleteSpendLimit(Long id) {
        spendLimitRepository.deleteById(id);
    }

    @GetMapping
    public List<SpendLimit> getAllSpendLimits() {
        return spendLimitRepository.findAll();
    }
}
