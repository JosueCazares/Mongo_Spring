package com.jyca.tareas.MongoSpring.CRUD.service;

import com.jyca.tareas.MongoSpring.CRUD.repository.ArticuloRepository;
import com.jyca.tareas.MongoSpring.CRUD.dto.ArticuloDto;
import com.jyca.tareas.MongoSpring.CRUD.model.Articulo;
import com.jyca.tareas.MongoSpring.global.exceptions.AttributeException;
import com.jyca.tareas.MongoSpring.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ArticuloService {
    @Autowired
    ArticuloRepository articuloRepository;

    public List<Articulo> getAll() {
        return articuloRepository.findAll();
    }

    public Articulo getOne(int id) throws ResourceNotFoundException {
        return articuloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Articulo no encontrado"));
    }
    public Articulo save(ArticuloDto dto) throws AttributeException {
        if(articuloRepository.existsByTitulo(dto.getTitulo()))
            throw new AttributeException("Titulo ya existe");
        int id = autoIncrement();
        Articulo a = new Articulo(id,dto.getTitulo(), dto.getContenido(), dto.getAutor(),dto.getFecha(),dto.getImagen(),dto.getCategoria(),dto.getLikes(),dto.getDislikes(),dto.getComentarios());
        return articuloRepository.save(a);
    }
    public Articulo update(int id,ArticuloDto dto) throws ResourceNotFoundException, AttributeException {
        Articulo a = articuloRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Articulo no encontrado"));
        if(articuloRepository.existsByTitulo(dto.getTitulo()) && articuloRepository.findByTitulo(dto.getTitulo()).get().getId() != id)
            throw new AttributeException("Titulo ya existe, no puedes poner el mismo nombre a dos articulos");
        a.setTitulo(dto.getTitulo());
        a.setContenido(dto.getContenido());
        a.setAutor(dto.getAutor());
        a.setFecha(dto.getFecha());
        a.setImagen(dto.getImagen());
        a.setCategoria(dto.getCategoria());
        a.setLikes(dto.getLikes());
        a.setDislikes(dto.getDislikes());
        a.setComentarios(dto.getComentarios());
        return articuloRepository.save(a);
    }

    public Articulo delete(int id) throws ResourceNotFoundException {
        Articulo a = articuloRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Articulo no encontrado"));
        articuloRepository.delete(a);
        return a;
    }
    //private metodos
    private int autoIncrement(){
        List<Articulo> articulos = articuloRepository.findAll();
        return articulos.isEmpty()? 1 :
                articulos.stream().max(Comparator.comparing(Articulo::getId)).get().getId() + 1;
    }
}

