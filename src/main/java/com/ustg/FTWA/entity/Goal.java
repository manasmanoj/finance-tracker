package com.ustg.FTWA.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private String title;
	@Column(precision = 10, scale = 2)
	private BigDecimal targetAmount;
	@Column(precision = 10, scale = 2)
	private BigDecimal currentAmount;
	private LocalDate deadline;

	@ManyToOne
	@JoinColumn(name = "username")
	@JsonIgnoreProperties({ "passWord", "monthly_income" })
	private User user;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("goals")
	private Category category;

	@OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Notifications> notifications;

}
