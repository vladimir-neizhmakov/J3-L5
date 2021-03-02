package com.flamexander.hibernate.HW5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private double cost;

    public Product(String title, double cost){
        this.title = title;
        this.cost = cost;
    }
    @Override
    public String toString() {
        return String.format("Product [id = %d, title = %s, cost = %.2f]", id, title, cost);
    }
}

