package com.example.posteo.service;
import com.example.posteo.model.Author;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    List<Author> obtenerTodos();
    Optional<Author> obtenerAutorPorId(Long id);
    Author crear(Author author);

}
