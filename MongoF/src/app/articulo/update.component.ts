import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ArticuloService } from '../services/articulo.service';
import { Articulo } from '../model/articulo';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrl: './update.component.css'
})
export class UpdateComponent implements OnInit{
  id!: number ;
  articulo!:Articulo;
  constructor(    
    private toast: ToastrService,
    private articuloService: ArticuloService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getArt();
  }

  onUpdate():void{
    this.articuloService.update(this.id, this.articulo).subscribe(
      data =>{
        this.toast.success('Articulo actualizado', 'OK', {timeOut: 3000, positionClass: 'toast-top-center'});
        this.router.navigate(['']);
      },
      err =>{
        this.toast.error(err.error.message, 'Fail', {timeOut: 3000, positionClass: 'toast-top-center'});
        this.router.navigate(['']);
      }
    )
  }
  getArt():void{
    this.id = this.activatedRoute.snapshot.params['id'];
    this.articuloService.detail(this.id).subscribe(
      data =>{
        this.articulo = data;
        console.log(this.articulo);
      },
      err=>{
        this.toast.error(err.error.message, 'Fail', {timeOut: 3000, positionClass: 'toast-top-center'});
        this.router.navigate(['/']);
      }
    )
  }
}
