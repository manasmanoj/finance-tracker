package com.ustg.FTWA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.entity.SpendLimit;
import com.ustg.FTWA.entity.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpendLimitRepository extends JpaRepository<SpendLimit, Long> {
    List<SpendLimit> findByUser(User user);

    List<SpendLimit> findByUserAndCategory(User user, Category category);

    List<SpendLimit> findByUserAndStartDateBeforeAndEndDateAfter(User user, LocalDate starDate, LocalDate endDate);
}
