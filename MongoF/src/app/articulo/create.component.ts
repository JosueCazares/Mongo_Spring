import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ArticuloService } from '../services/articulo.service';
import { Articulo } from '../model/articulo';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrl: './create.component.css'
})
export class CreateComponent implements OnInit{
  titulo!: string;
  contenido!: string ;
  fecha!: string ;
  autor!: string ;
  imagen!: string ;
  categoria!: string ;
  like!: number ;
  dislike!: number ;
  comentarios!: string ;
  constructor(
    private toast: ToastrService,
    private articuloService: ArticuloService,
    private router: Router
  ) { }
  ngOnInit(): void {
  }
  onCreate():void{
    const formData = new FormData();
  formData.append('imagen', this.imagen);
  formData.append('titulo', this.titulo);
  formData.append('contenido', this.contenido);
  formData.append('autor', this.autor);
  formData.append('fecha', this.fecha);
  formData.append('categoria', this.categoria);
  formData.append('like', '0');
  formData.append('dislike', '0');
    const articulo = new Articulo(this.titulo, this.contenido, this.autor,this.fecha, this.imagen, this.categoria, 0, 0);
    this.articuloService.create(formData).subscribe(
      data =>{
        this.toast.success(data.message, 'OK', {timeOut: 3000, positionClass: 'toast-top-center'});
        this.router.navigate(['']);
      },
      err =>{
        this.toast.error(err.error.message, 'Fail', {timeOut: 3000, positionClass: 'toast-top-center'});
        this.router.navigate(['/']);
      }
    )
  }
}
