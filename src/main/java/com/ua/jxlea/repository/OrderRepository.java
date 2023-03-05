package com.ua.jxlea.repository;

import com.ua.jxlea.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCardCustomerId(Long customerId);
    Optional<Order> findByPaymentId(Long id);
}
