import { Injectable } from '@angular/core';

@Injectable()
export class SessionService {

  constructor() { }

  public estaLogueado(): boolean {
    return localStorage.getItem('cine-id') != null;
  }
}
