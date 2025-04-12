package com.ustg.FTWA.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	private String username;
	private String passWord;
	@Column(precision = 10, scale = 2)
	private BigDecimal monthly_income;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public BigDecimal getMonthly_income() {
		return monthly_income;
	}

	public void setMonthly_income(BigDecimal monthly_income) {
		this.monthly_income = monthly_income;
	}

	public User() {
		super();
	}

	public User(String username, String passWord, BigDecimal monthly_income) {
		this.username = username;
		this.passWord = passWord;
		this.monthly_income = monthly_income;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", passWord=" + passWord + ", monthly_income=" + monthly_income + "]";
	}

}
