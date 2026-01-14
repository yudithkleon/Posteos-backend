package com.example.posteo.service;

import com.example.posteo.model.Posteo;
import com.example.posteo.repository.PosteoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
// Este es el paso 4 crear la interfaz  y 5 implementar el servicio de esa interfaz
@Service
public class PosteoService {
    // me traigo la intefaz del posteo del repositorio
    private final PosteoRepository posteoRepository;

    // Vamos a Inyectar con el constructor REEE IMportante
    public PosteoService(PosteoRepository posteoRepository){
        this.posteoRepository = posteoRepository;
    }


    //los http a usar aqui es donde los hago
    public List<Posteo> obtenerTodos() {
        System.out.println(" Service: obteniendo todos los posteos");
        return posteoRepository.findAll();
    }


    public Posteo obtenerPorId(Long id) {
        System.out.println("Service: obteniendo posteo por id");
        return posteoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro"));
    }


   public void crearPosteo(Posteo posteo) {
        System.out.println("Service: creando posteo");
        posteoRepository.save(posteo);
    }

    //Actualizar el put
    public Posteo actualizar(Long id, Posteo posteoActualizado){
        //debo ir a buscar si es id que quiero modificar está
        Posteo posteo = obtenerPorId(id);
        posteo.setTitulo(posteoActualizado.getTitulo());
        posteo.setContenido(posteoActualizado.getContenido());
        return posteoRepository.save(posteo);
    }

     public void eliminar(Long id){
       obtenerPorId(id);
       posteoRepository.deleteById(id);
    }

}
