package com.poletto.cursospringjava.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poletto.cursospringjava.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
