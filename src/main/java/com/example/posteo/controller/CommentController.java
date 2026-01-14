package com.example.posteo.controller;

import com.example.posteo.model.Comment;
import com.example.posteo.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> obtenerTodos() {
        return commentService.obtenerTodos();
    }

    @PostMapping("/crear/{posteoId}")
    public Comment crearComentario(
            @PathVariable Long posteoId,
            @Valid @RequestBody Comment comment
    ) {
        return commentService.crear(posteoId, comment);
    }

    @PutMapping("/{id}")
    public Comment actualizarComentario(
            @PathVariable Long id,
            @Valid @RequestBody Comment comment
    ) {
        return commentService.actualizar(id, comment);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        commentService.eliminar(id);
    }
}
