package com.qad.restfulwebservice.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_line")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private int quantity;
	private Date targetDate;

	@ManyToOne
	@JoinColumn(name = "orders_id", nullable = false)
	private Orders orders;
}