package com.qad.restfulwebservice.order;

import com.qad.restfulwebservice.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByArticle(String article);
}
