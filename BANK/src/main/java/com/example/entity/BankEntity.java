package com.example.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BankEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private BigDecimal amount;
    public enum type{
        INCOME,
        EXPENSE,
        SAVING
    }

      @Enumerated(EnumType.STRING)
      private type ty;
      private String category_id;
      private LocalDate date;
      private String description;

}
