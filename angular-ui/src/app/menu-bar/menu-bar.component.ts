import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent implements OnInit {
  items: MenuItem[];

  constructor(private router: Router) { }

  ngOnInit() {
    this.items = [
      {
        label: 'Reservas',
        icon: 'fa-file-o'
      }
    ];
  }

  logout(){
    localStorage.removeItem('cine-autorizacion');
    localStorage.removeItem('cine-rol');
    this.router.navigateByUrl('/');
  }
}
