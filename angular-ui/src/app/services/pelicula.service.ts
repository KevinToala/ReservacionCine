import { Injectable } from '@angular/core';
import {HttpService} from './http.service';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class PeliculaService {

  constructor(private httpService: HttpService) { }

  lista(): Observable<any[]> {
    return this.httpService.get('peliculas', false);
  }
}
