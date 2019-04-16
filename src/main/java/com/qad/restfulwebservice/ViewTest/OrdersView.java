package com.qad.restfulwebservice.ViewTest;

/**
 * Copyright (C) 2019-2019 Jan Adamczyk <j_adamczyk@hotmail.com>
 * <p>
 * Created: 15.04.19
 * This file is part of restful-web-service
 * <p>
 * This Code can not be copied and/or distributed without the express
 * permission of Jan Adamczyk
 */

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Table(name = "orders_view")
@Data
public class OrdersView {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	private String type;
	private int quantity;
	private Date targetDate;
}