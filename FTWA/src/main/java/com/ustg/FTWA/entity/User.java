package com.ustg.FTWA.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	private String username;
	private String passWord;
	@Column(precision = 10, scale = 2)
	private BigDecimal monthly_income;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Transaction> transactions;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Goal> goals;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Bank> bankTransactions;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Notifications> notifications;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<SpendLimit> spendLimits;

}
