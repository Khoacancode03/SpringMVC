package com.spring.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Product> products;
}
