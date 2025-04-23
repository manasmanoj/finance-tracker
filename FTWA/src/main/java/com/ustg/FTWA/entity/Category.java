package com.ustg.FTWA.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryType type;

    public enum CategoryType {
        INCOME,
        EXPENSE
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
