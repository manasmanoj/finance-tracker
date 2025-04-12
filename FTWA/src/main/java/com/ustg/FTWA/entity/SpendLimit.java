package com.ustg.FTWA.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import com.ustg.FTWA.entity.Category;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpendLimit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Double limitAmount;

    private LocalDate startDate;
    private LocalDate endDate;

    private Double alertThreshold; // e.g., 80.00 for 80%
}
