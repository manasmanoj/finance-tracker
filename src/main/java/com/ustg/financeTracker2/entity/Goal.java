package com.ustg.financeTracker2.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String title;
    @Column(precision = 10,scale = 2)
    private BigDecimal targetAmount;
    
    @Column(precision = 10,scale = 2)
    private BigDecimal currentAmount;
    private LocalDate deadline;

    public Goal() {
		super();
	}

	public Goal(Long id, Long userId, String title, BigDecimal targetAmount, BigDecimal currentAmount,
			LocalDate deadline, LocalDate createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
		this.deadline = deadline;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(BigDecimal targetAmount) {
		this.targetAmount = targetAmount;
	}

	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	private LocalDate createdAt;
}

