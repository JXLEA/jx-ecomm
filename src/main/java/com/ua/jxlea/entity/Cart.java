package com.ua.jxlea.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart extends AbstractEntity{

    @ManyToOne
    private Customer customer;

    @NonNull
    @Column
    @Enumerated(EnumType.STRING)
    private CartStatus cartStatus;

    public Cart(Customer customer, @NonNull CartStatus cartStatus) {
        this.customer = customer;
        this.cartStatus = cartStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(customer, cart.customer) && cartStatus == cart.cartStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, cartStatus);
    }
}
