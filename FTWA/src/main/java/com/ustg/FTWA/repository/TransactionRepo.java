package com.ustg.FTWA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ustg.FTWA.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	@Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.username = :username AND t.type = 'EXPENSE'")
	Double getTotalExpensesByUsername(@Param("username") String username);
	
	@Query("SELECT t.category.name, SUM(t.amount) FROM Transaction t " +
		       "WHERE t.username = :username AND t.type = 'EXPENSE' AND MONTH(t.date) = :month AND YEAR(t.date) = :year " +
		       "GROUP BY t.category.name")
	List<Object[]> getMonthlyExpensesByCategory(
		    @Param("username") String username,
		    @Param("month") int month,
		    @Param("year") int year);



}
