import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {MenuItem} from 'primeng/api';
import {SessionService} from '../services/session.service';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent implements OnInit {
  nombresUsuario: string;
  items: MenuItem[];

  constructor(private router: Router,
              public sessionService: SessionService) { }

  ngOnInit() {
    this.nombresUsuario = localStorage.getItem('cine-nombres');

    if (this.sessionService.estaLogueado()) {
      this.items = [
        {
          label: 'Peliculas',
          icon: 'fa-film',
          routerLink: '/peliculas'
        },
        {
          label: 'Mis Reservas',
          icon: 'fa-file-o',
          routerLink: '/misReservas'
        }
      ];
    }
    else {
      this.items = [
        {
          label: 'Peliculas',
          icon: 'fa-film',
          routerLink: '/peliculas'
        }
      ];
    }
  }

  logout(){
    localStorage.removeItem('cine-id');
    localStorage.removeItem('cine-nombres');
    localStorage.removeItem('cine-autorizacion');
    localStorage.removeItem('cine-rol');

    this.items = [
      {
        label: 'Peliculas',
        icon: 'fa-film',
        routerLink: '/peliculas'
      }
    ];

    this.router.navigateByUrl('/');
  }
}
