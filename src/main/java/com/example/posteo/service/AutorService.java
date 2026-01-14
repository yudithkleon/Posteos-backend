package com.example.posteo.service;

import com.example.posteo.model.Author;
import com.example.posteo.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService  implements IAutorService{
     private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Author> obtenerTodos() {
        return autorRepository.findAll();
    }
    @Override
    public Optional<Author> obtenerAutorPorId(Long id) {
        Author author = autorRepository.findById(id).orElseThrow();
        return Optional.of(author);
    }

    @Override
    public Author crear(Author author) {
        return autorRepository.save(author);
    }
}
