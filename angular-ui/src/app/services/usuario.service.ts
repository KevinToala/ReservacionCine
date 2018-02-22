import { Injectable } from '@angular/core';
import {HttpService} from './http.service';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class UsuarioService {

  constructor(private httpService: HttpService,
              private httpClient: HttpClient) { }

  registrar(usuario): Observable<any> {
    return this.httpService.post('usuarios', usuario, false);
  }

  login(usuarioLogin): Observable<any> {
    return this.httpClient.post('http://localhost:8080/login', null, {headers: this.getHeaders(usuarioLogin)});
  }

  private getHeaders(usuarioLogin) {
    return {
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest',
      'Authorization': `Basic ${btoa(usuarioLogin.username + ':' + usuarioLogin.clave)}`
    };
  }
}
