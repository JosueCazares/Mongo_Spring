export class Articulo {
    id!: number;
    titulo: string;
    contenido: string;
    autor: string;
    fecha: string;
    imagen: string;
    categoria: string;
    likes: number;
    dislikes: number;

    constructor(titulo: string, contenido: string, autor: string, fecha: string, imagen: string, categoria: string, likes: number, dislikes: number) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.autor = autor;
        this.fecha = fecha;
        this.imagen = imagen;
        this.categoria = categoria;
        this.likes = likes;
        this.dislikes = dislikes;
    }
}
