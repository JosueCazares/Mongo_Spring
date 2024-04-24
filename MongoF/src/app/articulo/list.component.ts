import { Component, OnInit } from '@angular/core';
import { Articulo } from '../model/articulo';
import { ToastrService } from 'ngx-toastr';
import { ArticuloService } from '../services/articulo.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit{
  articulos: Articulo[] = [];
  constructor( 
    private articuloService: ArticuloService,
    private toast: ToastrService) { 
   
  }
  ngOnInit(): void {
    this.getArt();
  }
  getArt():void{
    this.articuloService.list().subscribe(
      data =>{
        this.articulos = data;
      },
      err  =>{
        this.toast.error(err.error.message, 'Fail', {timeOut: 3000, positionClass: 'toast-top-center'});
      }
    );
  }
  onDelete(id: number): void{
    Swal.fire({
      title: '¿Está seguro de continuar?',
      text: 'No podrás revertir esto!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, eliminar!',
      cancelButtonText: 'No, cancelar'
    }).then((result)=>{
      if(result.value){
        this.articuloService.delete(id).subscribe( data =>{
          this.toast.success(data.message, 'OK', {timeOut: 3000, positionClass: 'toast-top-center'});
          this.getArt();
        },
        err =>{
          this.toast.error(err.error.message, 'Fail', {timeOut: 3000, positionClass: 'toast-top-center'});
        })
      }
      else if(result.dismiss === Swal.DismissReason.cancel){
        Swal.fire('Cancelado', 'Tu archivo está seguro :)', 'error');
      }
    })
  }
}