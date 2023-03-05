package com.ua.jxlea.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "payments")
public class Payment extends AbstractEntity{

    @Column(name = "paypal_payment_id")
    private String paypalPaymentId;

    @NonNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @NonNull
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    public Payment(String paypalPaymentId, @NonNull PaymentStatus paymentStatus, @NonNull BigDecimal amount) {
        this.paypalPaymentId = paypalPaymentId;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paypalPaymentId, payment.paypalPaymentId) && paymentStatus.equals(payment.paymentStatus) && amount.equals(payment.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paypalPaymentId, paymentStatus, amount);
    }
}
