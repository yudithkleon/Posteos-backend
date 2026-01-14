package com.example.posteo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

//Aqui es el paso 1 despues de la creacion de las carpetas que es la capa de arquitectura de spring
//Esto es como si estubiera creando el tipado de dato o una interface de ts lago similar
// Esto es como si estuviese diciendo en js
// const posteo = {
//            id: 1,
//            titulo: "Mi primer post",
//            autor: "Yudith"
//   }
//luego de conestar las dependencias, la mysql entonces combeirto este model  en una entidad

@Entity
@Table(name= "posteos")
public class Posteo {
    // Creacion de los tipos de datos
    // lo cocnecto con
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private String titulo;
    // private  String autor;

    //parte 2 de la guia agregamos las validaciones
    @NotBlank
    @Size(max=100)
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(nullable = false)
    private LocalDateTime fecha_creacion;

    /*Parte 3 relaciones porque el posteo depende del autor*/
    /*Evitar el error infinito @JsonIgnore*/
    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private Author author;

    @OneToMany(mappedBy = "posteo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Comment> comments;



    /* ahora hago el constructor completo con todo */

    // Constructor vacío (Spring lo necesita)
    public Posteo() {
        this.fecha_creacion= LocalDateTime.now();
    }

/*    public Posteo(Long id, String titulo, String autor) {
        this.id=id;
        this.titulo=titulo;
        this.contenido=contenido;
        this.
    }*/


    //Ahora vamos hacer los gert y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido(){
        return  contenido;
    }
    public void setContenido(String contenido){
        this.contenido= contenido;
    }
    public LocalDateTime getFechaCreacion(){
        return fecha_creacion;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}



