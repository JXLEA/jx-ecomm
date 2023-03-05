package com.ua.jxlea.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;
    @OneToMany(mappedBy = "customer")
    private Set<Cart> cartSet;

    public Customer(String firstName, String lastName, String email,
                    String telephone, Boolean enabled, Set<Cart> cartSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.enabled = enabled;
        this.cartSet = cartSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(telephone, customer.telephone) && Objects.equals(enabled, customer.enabled) && Objects.equals(cartSet, customer.cartSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, telephone, enabled, cartSet);
    }
}
