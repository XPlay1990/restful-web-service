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
import java.util.Set;

@Data
@Entity
@Table(name="CART")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToMany(mappedBy="cart")
	private Set<Item> items;
}