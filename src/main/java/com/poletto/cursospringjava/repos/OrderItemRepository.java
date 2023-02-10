package com.poletto.cursospringjava.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poletto.cursospringjava.entities.OrderItem;
import com.poletto.cursospringjava.entities.User;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
