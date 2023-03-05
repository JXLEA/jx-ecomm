package com.ua.jxlea.repository;

import com.ua.jxlea.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findAllByAmountBetween(BigDecimal min, BigDecimal max);
}
