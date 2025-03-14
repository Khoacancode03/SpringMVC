package com.spring.service;

import com.spring.model.Author;
import com.spring.model.Product;
import com.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

//    List<Product> productList = new ArrayList<Product>();
//
//    public ProductServiceImpl() {
//        List<Author> authors = new ArrayList<>();
//        for (int i = 1; i <= 6; i++) {
//            authors.add(new Author("A" + i, "Meow"));
//        }
//        productList.add(new Product("P1", "Em thích ăn thịt lợn và ghét học hóa, anh tặng em heo không hóa", 9.99, 100, "https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/482552lNR/anh-mo-ta.png", authors.get(0)));
//        productList.add(new Product("P2", "Mèo ngô", 8.99, 50, "https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/482552lNR/anh-mo-ta.png", authors.get(1)));
//        productList.add(new Product("P3", "Mèo gầy không béo", 15.99, 75, "https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/482552lNR/anh-mo-ta.png", authors.get(2)));
//        productList.add(new Product("P4", "Thế giới của Meow", 12.49, 30, "https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/482552lNR/anh-mo-ta.png", authors.get(3)));
//        productList.add(new Product("P5", "Mèo và Chó", 19.99, 20, "https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/482552lNR/anh-mo-ta.png", authors.get(4)));
//        productList.add(new Product("P6", "Chó và những người mèo", 17.59, 10, "https://img.tripi.vn/cdn-cgi/image/width=700,height=700/https://gcs.tripi.vn/public-tripi/tripi-feed/img/482552lNR/anh-mo-ta.png", authors.get(5)));
//    }

    @Override
    public Product create(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product update(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getOne(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page-1, size));
    }

    @Override
    public Product delete(String id) {
        Product product =  productRepository.findById(id).orElse(null);
        assert product != null;
        productRepository.delete(product);
        return product;
    }
}
