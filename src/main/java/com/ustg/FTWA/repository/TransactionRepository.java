package com.ustg.FTWA.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.FTWA.entity.Category;
import com.ustg.FTWA.entity.Transaction;
import com.ustg.FTWA.entity.User;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByUser(User user);

	List<Transaction> findByCategory(Category category);

	List<Transaction> findByUserAndDateBetween(User user, LocalDate start, LocalDate end);

	List<Transaction> findByUserAndCategory(User user, Category category);

}
