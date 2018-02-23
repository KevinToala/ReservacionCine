import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {PeliculaService} from '../services/pelicula.service';
import {SessionService} from '../services/session.service';
import {OverlayPanel} from 'primeng/primeng';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-peliculas',
  templateUrl: './peliculas.component.html',
  styleUrls: ['./peliculas.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class PeliculasComponent implements OnInit {
  peliculas: any[];
  peliculaOverlayPanel: any;
  dialogReservaVisible = false;
  peliculaReservar: any;
  pasosReservacion: MenuItem[];
  activeIndexStepReserva: number;

  constructor(private peliculaService: PeliculaService,
              public sessionService: SessionService) {
    this.activeIndexStepReserva = 0;
    this.peliculas = [{}];
    this.pasosReservacion = [
      {label: 'Función'},
      {label: 'Asientos'},
      {label: 'Confirmación'}
    ];
  }

  ngOnInit() {
    this.peliculaService.lista()
      .subscribe(value => this.peliculas = value);
  }

  mostrarInfoPelicula(event, pelicula, overlaypanel: OverlayPanel) {
    this.peliculaOverlayPanel = pelicula;
    overlaypanel.toggle(event);
  }

  mostrarDialogoReserva(pelicula): void {
    this.dialogReservaVisible = true;
    this.peliculaReservar = pelicula;
  }

  siguientePasoReserva(){
    this.activeIndexStepReserva++;
  }

  reservar(){
    this.dialogReservaVisible = false;
  }
}
