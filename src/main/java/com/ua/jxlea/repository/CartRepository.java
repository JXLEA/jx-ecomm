package com.ua.jxlea.repository;

import com.ua.jxlea.entity.Cart;
import com.ua.jxlea.entity.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByStatus(CartStatus cartStatus);

    List<Cart> findByStatusAndCustomerId(CartStatus cartStatus, Long customerId);
}
