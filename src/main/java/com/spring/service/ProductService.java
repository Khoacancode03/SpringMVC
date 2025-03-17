package com.spring.service;

import com.spring.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product create (Product product);
    Product update (Product product);
    Product getOne (String id);
    List<Product> getAll ();
    Page<Product> getAll (int page, int size);
    Product delete (String id);

}
