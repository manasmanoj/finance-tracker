package com.ustg.spendLimits.repository;

import com.ustg.spendLimits.entity.SpendLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpendLimitRepository extends JpaRepository<SpendLimit, Long> {
    List<SpendLimit> findByUsername(String username);
}
