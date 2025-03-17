package com.spring.repository;

import com.spring.model.Author;
import com.spring.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findByAuthorIn(List<Author> author, Pageable pageable);
    Page<Product> findByNameLikeOrAuthorIn(String name, List<Author> author, Pageable pageable);

    //@Transactional
    //@Modifying
    @Query(value = "SELECT p from Product p WHERE p.name LIKE ?1 OR p.author IN ?2",
           countQuery = "SELECT COUNT(p) FROM Product p WHERE p.name LIKE ?1 OR p.author IN ?2")
    Page<Product> search(String name, List<Author> author, Pageable pageable);


}
