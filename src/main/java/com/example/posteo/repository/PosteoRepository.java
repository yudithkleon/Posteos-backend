/*
package com.example.posteo.repository;

import com.example.posteo.model.Posteo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
// aqui es el paso 2 crear la interfaz del repositorio y 3 implementar esa interfaz es como simulo la base de dato es como si e
// como si hiciera el array en js con datos
@Repository
public class PosteoRepository implements IPosteoRepository{

    private List<Posteo> posteos = new ArrayList<>();

    //colocamos datos de ejm
    public PosteoRepository(){
        posteos.add(new Posteo(1L, "No me gusta que vea Demon Slayer", "Yudith"));
        posteos.add(new Posteo(2L, "Me gusta Demon Slayer", "Melani"));
    }

    @Override
    public List<Posteo> findAll() {
        System.out.println("En Repository: devolviendo todos los posteos");
        return posteos;
    }

    @Override
    public Posteo findById(Long id) {
        System.out.println("Repository: devolviendo todos los posteos por el ID" + id);
        return posteos.stream().filter(p-> p.getId().equals(id)).findFirst().orElse(null);

    }

    @Override
    public void save(Posteo posteo) {
        System.out.println("Estoy guardando el posteo....");
        posteos.add(posteo);
    }
}
*/


//Paso 2
package com.example.posteo.repository;

import com.example.posteo.model.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteoRepository extends JpaRepository<Posteo, Long> {
}

