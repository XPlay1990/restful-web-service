package com.qad.restfulwebservice.shop.model;

/**
 * Copyright (C) 2019-2019 Jan Adamczyk <j_adamczyk@hotmail.com>
 * <p>
 * Created: 14.04.19
 * This file is part of restful-web-service
 * <p>
 * This Code can not be copied and/or distributed without the express
 * permission of Jan Adamczyk
 */

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;


	//...
	@ManyToOne
	@JoinColumn(name="cart_id", nullable=false)
	private Cart cart;

	public Item() {}

	// getters and setters
}