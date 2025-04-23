package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.Bank;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public Bank saveBankTransaction(Bank bank) {
        return bankRepository.save(bank);
    }

    public List<Bank> getAllTransactions() {
        return bankRepository.findAll();
    }

    public List<Bank> getTransactionsByUser(User user) {
        return bankRepository.findByUser(user);
    }

    public void deleteTransaction(Long id) {
        bankRepository.deleteById(id);
    }

    public Bank getTransactionById(Long id) {
        return bankRepository.findById(id).orElse(null);
    }
}
