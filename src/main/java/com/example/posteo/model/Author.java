package com.example.posteo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

// parte 3 creo Autor creo la entidad y le digo que es una tabla
@Entity
@Table(name="author")
public class Author {

   //creamos los campos id-autoincremento, name, email
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_author;
    @NotBlank(message="El nombre no puede estar vacío")
    @Column(nullable = false)
    private String nombre;
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "Debe ser un email válido")
    @Column(nullable = false, unique = true)
    private String email;

    /*parte 3 relación con  Posteo*/
    @OneToMany( mappedBy = "author")
    @JsonIgnore
    private List<Posteo> posteo;

    //getters y setters
    public Long getId_author() {
        return id_author;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setId_author(Long id_author) {
        this.id_author = id_author;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Posteo> getPosteo() {
        return posteo;
    }

    public void setPosteo(List<Posteo> posteo) {
        this.posteo = posteo;
    }
}
