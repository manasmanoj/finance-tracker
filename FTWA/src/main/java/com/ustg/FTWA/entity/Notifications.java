package com.ustg.FTWA.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;

    @Column(name = "is_read")
    private boolean isRead = false;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;
}
