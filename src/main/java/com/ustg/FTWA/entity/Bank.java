package com.ustg.FTWA.entity;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
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
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bankTransactionId;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    public Choose choose;
    private String categoryId;
    private String date;
    private String description;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public enum Choose {
        INCOME,
        EXPENSE,
        SAVING
    }

}
