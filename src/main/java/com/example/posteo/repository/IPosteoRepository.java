package com.example.posteo.repository;

import com.example.posteo.model.Posteo;

import java.util.List;

public interface IPosteoRepository {
    //vamos hacer una lista de posteo todos los vamos a traer
    List<Posteo>  findAll();

    // una lista de posteo ppor id- es decir traigo uno por el id
    Posteo findById(Long id);

    //donde guardar
    void save(Posteo posteo);
}
