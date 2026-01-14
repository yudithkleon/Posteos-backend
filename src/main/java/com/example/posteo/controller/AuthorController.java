package com.example.posteo.controller;

import com.example.posteo.model.Author;
import com.example.posteo.service.IAutorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AuthorController {
    private final IAutorService autorService;


    public AuthorController(IAutorService autorService) {
        this.autorService = autorService;
    }

 // del servicio que es el que tiene la lógica me traigo que e slo que voy a delegar acá
 @GetMapping
    public List<Author> obtenerTodos() {
     return autorService.obtenerTodos();
 }
   @GetMapping("/{id}")
    public Author obtenerAutorPorId(@PathVariable  Long id) {
        return autorService.obtenerAutorPorId(id)
                .orElseThrow(()-> new RuntimeException("Autor no encontrado"));
    }

    //el Valid valida el objeto antes de hacer la acción
    @PostMapping("/crear")
    public Author crear(@Valid @RequestBody Author author) {
        return autorService.crear(author);
    }
}
