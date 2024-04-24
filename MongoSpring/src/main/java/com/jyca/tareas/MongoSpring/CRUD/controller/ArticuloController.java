package com.jyca.tareas.MongoSpring.CRUD.controller;

import com.jyca.tareas.MongoSpring.CRUD.service.ArticuloService;
import com.jyca.tareas.MongoSpring.CRUD.dto.ArticuloDto;
import com.jyca.tareas.MongoSpring.CRUD.model.Articulo;
import com.jyca.tareas.MongoSpring.global.dto.MessageDto;
import com.jyca.tareas.MongoSpring.global.exceptions.AttributeException;
import com.jyca.tareas.MongoSpring.global.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticuloController {
    @Autowired
    ArticuloService articuloService;

    @GetMapping
    public ResponseEntity<List<Articulo>> getAll(){
        return ResponseEntity.ok(articuloService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Articulo> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(articuloService.getOne(id));
    }
    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody ArticuloDto dto) throws AttributeException {
        Articulo articulo=articuloService.save(dto);
        String message="Articulo: "+articulo.getTitulo()+" creado con éxito";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK,message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") int id, @Valid @RequestBody ArticuloDto dto) throws ResourceNotFoundException, AttributeException {
        Articulo articulo=articuloService.update(id,dto);
        String message="Articulo: "+articulo.getTitulo()+" actualizado con éxito";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK,message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        Articulo articulo=articuloService.delete(id);
        String message="Articulo: "+articulo.getTitulo()+" eliminado con éxito";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK,message));
    }
}
