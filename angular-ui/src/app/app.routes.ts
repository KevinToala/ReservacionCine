import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {RegistroUsuarioComponent} from './registro-usuario/registro-usuario.component';
import {LoginComponent} from './login/login.component';
import {FuncionesComponent} from './funciones/funciones.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'registro', component: RegistroUsuarioComponent },
  { path: 'funciones', component: FuncionesComponent }
];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
