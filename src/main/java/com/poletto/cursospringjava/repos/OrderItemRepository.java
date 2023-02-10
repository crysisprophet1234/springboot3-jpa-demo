package com.poletto.cursospringjava.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poletto.cursospringjava.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
