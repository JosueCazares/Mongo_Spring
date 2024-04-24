package com.jyca.tareas.MongoSpring.CRUD.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articulo")

public class Articulo {

    private int id;
    private String titulo;
    private String contenido;
    private String autor;
    private String fecha;
    private String imagen;
    private String categoria;
    private int likes;
    private int dislikes;
    private String comentarios;

    public Articulo() {
    }

    public Articulo(int id, String titulo, String contenido, String autor, String fecha, String imagen, String categoria, int likes, int dislikes, String comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.autor = autor;
        this.fecha = fecha;
        this.imagen = imagen;
        this.categoria = categoria;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
