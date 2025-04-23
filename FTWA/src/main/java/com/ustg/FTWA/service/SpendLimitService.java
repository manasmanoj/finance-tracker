package com.ustg.FTWA.service;

import com.ustg.FTWA.entity.SpendLimit;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.repository.SpendLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SpendLimitService {

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
}
