package com.example.posteo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    /* Parte 3-Relación: muchos comentarios pertenecen a un posteo */
    @ManyToOne
    @JoinColumn(name = "posteo_id", nullable = false)
    private Posteo posteo;

    public Comment() {
        this.createdAt = LocalDateTime.now();
    }

    // getters y setters
    public Long getId() { return id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public Posteo getPosteo() { return posteo; }
    public void setPosteo(Posteo posteo) { this.posteo = posteo; }

}
