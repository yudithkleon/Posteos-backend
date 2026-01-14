package com.example.posteo.service;

import com.example.posteo.model.Comment;
import com.example.posteo.model.Posteo;
import com.example.posteo.repository.CommentRepository;
import com.example.posteo.repository.PosteoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PosteoRepository posteoRepository;

    public CommentService(CommentRepository commentRepository, PosteoRepository posteoRepository) {
        this.commentRepository = commentRepository;
        this.posteoRepository = posteoRepository;
    }

    public List<Comment> obtenerTodos() {
        return commentRepository.findAll();
    }

    public Comment crear(Long posteoId, Comment comment) {
        Posteo posteo = posteoRepository.findById(posteoId)
                .orElseThrow(() -> new RuntimeException("Posteo no encontrado"));

        comment.setPosteo(posteo);
        return commentRepository.save(comment);
    }

    public void eliminar(Long id) {
        commentRepository.deleteById(id);
    }
}
