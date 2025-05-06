package com.ustg.FTWA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.FTWA.entity.Bank;
import com.ustg.FTWA.entity.User;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

  List<Bank> findByUser(User user);
}
