package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.BankEntity;

public interface BankRepo extends JpaRepository<BankEntity, Long> {

}
