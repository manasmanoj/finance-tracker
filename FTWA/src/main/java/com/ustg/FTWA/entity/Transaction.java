package com.ustg.FTWA.entity;

import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private LocalDate date;
    private String description;

    private enum Type {
        INCOME,
        EXPENSE,
        SAVING
    }
}
