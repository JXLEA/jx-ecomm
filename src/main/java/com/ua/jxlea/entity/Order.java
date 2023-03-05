package com.ua.jxlea.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity{

    @NonNull
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "shipped")
    private ZonedDateTime shipped;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(unique = true)
    private Payment payment;

    @Embedded
    private Address shipmentAddress;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<OrderItem> orderItems;

    @OneToOne
    private Cart cart;

    public Order(@NonNull BigDecimal price, @NonNull OrderStatus orderStatus, ZonedDateTime shipped,
                 Payment payment, Address shipmentAddress, Set<OrderItem> orderItems, Cart cart) {
        this.price = price;
        this.orderStatus = orderStatus;
        this.shipped = shipped;
        this.payment = payment;
        this.shipmentAddress = shipmentAddress;
        this.orderItems = orderItems;
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return price.equals(order.price) && orderStatus == order.orderStatus && Objects.equals(shipped, order.shipped) && Objects.equals(payment, order.payment) && Objects.equals(shipmentAddress, order.shipmentAddress) && Objects.equals(orderItems, order.orderItems) && Objects.equals(cart, order.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, orderStatus, shipped, payment, shipmentAddress, orderItems, cart);
    }
}
