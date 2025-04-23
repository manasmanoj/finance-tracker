package com.ustg.FTWA.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private User user;

	@OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
	private List<Notifications> notifications;

}
