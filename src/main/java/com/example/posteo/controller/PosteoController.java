package com.example.posteo.controller;

import com.example.posteo.model.Posteo;
import com.example.posteo.service.PosteoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Aqui conecto con el cliente este es la entrada http y llamo a todo mi data

@RestController
@RequestMapping("/posteos")
public class PosteoController {
     private final PosteoService posteoService;

     // le inyecto al constructor
     public PosteoController(PosteoService posteoService){
         this.posteoService= posteoService;
     }

     // la llamado con la peticion GET
    @GetMapping
    public List<Posteo> obtenerTodos(){
        System.out.println("-Controller: GET /posteos");
        return posteoService.obtenerTodos();
      //  return ResponseEntity.ok(posteoService.obtenerTodos());
    }

   @GetMapping("/{id}")
   public Posteo obtenerPorId(@PathVariable Long id){
       System.out.println("Controller: GET /posteos/" + id);
        return posteoService.obtenerPorId(id);
    }

   @PostMapping("/crear")
    public void crearPosteo(@RequestBody Posteo posteo){
       System.out.println("-Controller: POST /posteos/crear");
       posteoService.crearPosteo(posteo);
    }

    @PutMapping("/{id}")
    public Posteo actualizar(@PathVariable Long id, @Valid @RequestBody Posteo posteo){
         return posteoService.actualizar(id, posteo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
         posteoService.eliminar(id);
    }

   }
