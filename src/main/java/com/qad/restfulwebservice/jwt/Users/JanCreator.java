package com.qad.restfulwebservice.jwt.Users;

import com.qad.restfulwebservice.order.OrderRepository;
import com.qad.restfulwebservice.order.model.ConfirmedOrderLine;
import com.qad.restfulwebservice.order.model.OrderLine;
import com.qad.restfulwebservice.order.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JanCreator {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	public void execute() {
		JwtUser jan = new JwtUser();
		jan.setEmail("j_adamczyk@hotmail.com");
		jan.setFirstName("Jan");
		jan.setLastName("Adamczyk");
		jan.setUsername("XPlay");
		jan.setPassword("$2a$10$cJTYjQ5wj.w8cGiYxqEy6.j4rLBJ5Lprdx7Iz2QGxZbfQxPhsAgRS");
		jan.activateUser();


		UserRole admin = new UserRole();
		admin.setAuthority("admin");
		ArrayList<UserRole> userRoles = new ArrayList<>();
		userRoles.add(admin);
		jan.setAuthorities(userRoles);

		if (userRepository == null) {
			System.out.println("WTF ITS NULL");
		}

		userRepository.save(jan);


		Date currentDate = new Date();
		// convert date to localdatetime
		LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localDateTime = localDateTime.plusMonths(1).plusDays(1);
		Date futureDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		OrderLine orderLine = OrderLine.builder().quantity(10).targetDate(futureDate).build();
		ConfirmedOrderLine confirmedOrderLine = ConfirmedOrderLine.builder().confirmedTargetDate(futureDate).quantity(1337).build();

		ArrayList<OrderLine> orderLines = new ArrayList<>();
		orderLines.add(orderLine);
		ArrayList<ConfirmedOrderLine> confirmedOrderLines = new ArrayList<>();
		confirmedOrderLines.add(confirmedOrderLine);

		Orders orders = Orders.builder().article("Pommes").destination("Deutschland")
				.confirmedOrderLineList(confirmedOrderLines).orderLineList(orderLines)
				.build();
		orderRepository.save(orders);
		List<Orders> pommes = orderRepository.findByArticle("Pommes");
		orderRepository.delete(pommes.get(0));
	}
}
