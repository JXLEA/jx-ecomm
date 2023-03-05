package com.ua.jxlea.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem extends AbstractEntity {

    @NonNull
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    public OrderItem(@NonNull Long quantity, Product product, Order order) {
        this.quantity = quantity;
        this.product = product;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity.equals(orderItem.quantity) && Objects.equals(product, orderItem.product) && Objects.equals(order, orderItem.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, product, order);
    }
}
