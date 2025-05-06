package com.ustg.FTWA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        LIMIT_ALERT,
        GOAL_ACHIEVED,
        REMINDER
    }

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "is_read")
    private boolean isRead = false;

    @ManyToOne
    @JoinColumn(name = "username")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    @JsonIgnore
    private Goal goal;
}
