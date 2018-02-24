import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {PeliculaService} from '../services/pelicula.service';
import {SessionService} from '../services/session.service';
import {OverlayPanel} from 'primeng/primeng';
import {MenuItem} from 'primeng/api';
import {FuncionService} from '../services/funcion.service';

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

  funciones: any[];
  funcionSeleccionada: any;

  butacas: any[];
  butacasSeleccionadas: any[];

  constructor(private peliculaService: PeliculaService,
              public sessionService: SessionService,
              private funcionService: FuncionService) {
    this.activeIndexStepReserva = 0;
    this.peliculas = [{}];
    this.butacas = [];
    this.butacasSeleccionadas = [];
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

    this.funcionService.listaFunciones(pelicula.id).subscribe(funciones => {
      this.funciones = funciones;
    })
  }

  siguientePasoReserva(){
    this.activeIndexStepReserva++;

    if (this.activeIndexStepReserva == 1) {
      this.funcionService.butacas(this.funcionSeleccionada.id)
        .subscribe(butacas => this.butacas = butacas);
    }
  }

  reservar(){
    this.dialogReservaVisible = false;
    this.activeIndexStepReserva = 0;
  }

  seleccionarButaca(checked, butaca): void {
    console.log(checked);
    console.log(butaca)

    if (checked) {
      this.butacasSeleccionadas.push(butaca.id);
    }
    else {
      const indiceButaca = this.butacasSeleccionadas.findIndex(idButaca => idButaca == butaca.id);
      this.butacasSeleccionadas.splice(indiceButaca, 1);
    }
  }
}
