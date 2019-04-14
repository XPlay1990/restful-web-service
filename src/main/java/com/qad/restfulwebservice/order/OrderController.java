package com.qad.restfulwebservice.order;

import com.qad.restfulwebservice.order.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/users/{username}/orders")
    public List<Orders> getAllTodos(@PathVariable String article) {
        return orderRepository.findByArticle(article);
    }
}
