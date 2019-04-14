package com.qad.restfulwebservice.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String article;
	private String destination;

//	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderLine> orderLineList;

//	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ConfirmedOrderLine> confirmedOrderLineList;
}