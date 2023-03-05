package com.ua.jxlea.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends AbstractEntity {

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProductStatus status;
    @Column(name = "sales_counter")
    private Integer salesCounter;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "product_reviews",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "reviews_id"))
    private Set<Review> reviews = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Set<Category> categories;

    public Product(@NonNull String name, String description, @NonNull BigDecimal price, @NonNull ProductStatus status,
                   Integer salesCounter, Set<Review> reviews, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
        this.salesCounter = salesCounter;
        this.reviews = reviews;
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && Objects.equals(description, product.description) && price.equals(product.price) && status == product.status && Objects.equals(salesCounter, product.salesCounter) && Objects.equals(reviews, product.reviews) && Objects.equals(categories, product.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, status, salesCounter, reviews, categories);
    }
}
