import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {RegistroUsuarioComponent} from './registro-usuario/registro-usuario.component';
import {LoginComponent} from './login/login.component';
import {PeliculasComponent} from './peliculas/peliculas.component';
import {MisReservasComponent} from './mis-reservas/mis-reservas.component';

export const routes: Routes = [
  { path: '', redirectTo: 'peliculas', pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroUsuarioComponent },
  { path: 'peliculas', component: PeliculasComponent },
  { path: 'misReservas', component: MisReservasComponent }
];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
