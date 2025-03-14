package com.spring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    @Column(name = "total_sold")
    private Integer totalSold;
    private String image;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
