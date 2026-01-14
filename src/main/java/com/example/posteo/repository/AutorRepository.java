package com.example.posteo.repository;

import com.example.posteo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Author, Long> {
}
