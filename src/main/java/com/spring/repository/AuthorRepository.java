package com.spring.repository;

import com.spring.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, String> {
    List<Author> findByNameLike(String name);
}
