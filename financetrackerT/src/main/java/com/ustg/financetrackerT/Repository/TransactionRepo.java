package com.ustg.financetrackerT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.financetrackerT.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

}
