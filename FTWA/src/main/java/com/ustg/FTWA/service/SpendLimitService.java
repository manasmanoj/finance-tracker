package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.SpendLimit;
import com.ustg.FTWA.repository.SpendLimitRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpendLimitService {
	@Autowired
    private final SpendLimitRepository spendLimitRepository;

    public SpendLimit saveSpendLimit(SpendLimit spendLimit) {
        return spendLimitRepository.save(spendLimit);
    }

    public List<SpendLimit> getAllSpendLimits() {
        return spendLimitRepository.findAll();
    }

    public Optional<SpendLimit> getSpendLimitById(Long id) {
        return spendLimitRepository.findById(id);
    }

    public List<SpendLimit> getSpendLimitsByUsername(String username) {
        return spendLimitRepository.findByUsername(username);
    }

    public void deleteSpendLimit(Long id) {
        spendLimitRepository.deleteById(id);
    }
}
