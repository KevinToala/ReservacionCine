import { Injectable } from '@angular/core';
import {HttpService} from './http.service';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class FuncionService {

  constructor(private httpService: HttpService) { }

  public listaFunciones(idPelicula: string): Observable<any> {
    return this.httpService.get(`peliculas/${idPelicula}/funciones`)
  }

  public butacas(idFuncion): Observable<any> {
    return this.httpService.get(`funciones/${idFuncion}/butacas`)
  }

  public reservar(reserva): Observable<any> {
    return this.httpService.post('reservas', reserva);
  }
}
