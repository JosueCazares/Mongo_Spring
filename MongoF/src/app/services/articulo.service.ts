import { Injectable } from '@angular/core';
import { environment } from '../../enviroment/enviroment';
import { HttpClient } from '@angular/common/http';
import { Articulo } from '../model/articulo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticuloService {

  articuloURL = environment.apiRestUrl + '/articulo';
  constructor(private httpClient : HttpClient) { }

  public list(): Observable<Articulo[]>{
return this.httpClient.get<Articulo[]>(this.articuloURL);
  }

  public detail(id: number): Observable<Articulo>{
    return this.httpClient.get<Articulo>(this.articuloURL + `/${id}`);
  }

  public create(articulo: FormData): Observable<any>{
    return this.httpClient.post<any>(this.articuloURL, articulo);
  }
  public update(id: number,articulo: Articulo): Observable<any>{
    return this.httpClient.put<any>(this.articuloURL+ `/${id}`, articulo);
  }
  public delete(id: number): Observable<any>{
    return this.httpClient.delete<Articulo>(this.articuloURL + `/${id}`);
  }
}
