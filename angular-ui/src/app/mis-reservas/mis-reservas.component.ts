import { Component, OnInit } from '@angular/core';
import {FuncionService} from '../services/funcion.service';

@Component({
  selector: 'app-mis-reservas',
  templateUrl: './mis-reservas.component.html',
  styleUrls: ['./mis-reservas.component.css']
})
export class MisReservasComponent implements OnInit {
  reservas: any[];

  constructor(private funcionService: FuncionService) { }

  ngOnInit() {
    this.funcionService.obtenerReservas(localStorage.getItem('cine-id'))
      .subscribe(value => this.reservas = value);

  }

}
