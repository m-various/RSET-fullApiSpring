package com.test.db.products;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @NotNull
    @Column(unique=true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public Product(ProductCategory category, String name, Long price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Product() {}

    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private String name;
    private Long price;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (category != product.category) return false;
        if (!name.equals(product.name)) return false;
        return price.equals(product.price);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
