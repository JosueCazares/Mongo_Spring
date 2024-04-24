package com.jyca.tareas.MongoSpring.CRUD.repository;

import com.jyca.tareas.MongoSpring.CRUD.model.Articulo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticuloRepository extends MongoRepository<Articulo, Integer>{
    Boolean existsByTitulo(String titulo);
    Optional<Articulo> findByTitulo(String titulo);
}
