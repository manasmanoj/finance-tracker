package com.ustg.FTWA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ustg.FTWA.entity.SpendLimit;

import java.util.List;

public interface SpendLimitRepository extends JpaRepository<SpendLimit, Long> {
    List<SpendLimit> findByUsername(String username);
}
