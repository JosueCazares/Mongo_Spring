import { Component, OnInit } from '@angular/core';
import { ArticuloService } from '../services/articulo.service';
import { ToastrService } from 'ngx-toastr';
import { Router, ActivatedRoute } from '@angular/router';
import { Articulo } from '../model/articulo';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrl: './detail.component.css'
})
export class DetailComponent implements OnInit{
  articulo: Articulo | undefined;
  constructor(
    private toast: ToastrService,
    private articuloService: ArticuloService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) { }
  ngOnInit(): void {
    this.getArt();
  }
  getArt():void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.articuloService.detail(id).subscribe(
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
