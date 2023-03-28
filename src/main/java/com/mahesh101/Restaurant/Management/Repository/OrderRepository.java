package com.mahesh101.Restaurant.Management.Repository;


import com.mahesh101.Restaurant.Management.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

