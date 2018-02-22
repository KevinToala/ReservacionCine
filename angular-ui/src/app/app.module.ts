import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegistroUsuarioComponent } from './registro-usuario/registro-usuario.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppRoutes} from './app.routes';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import {HttpService} from './services/http.service';
import {UsuarioService} from './services/usuario.service';
import {CardModule} from 'primeng/card';
import {CalendarModule, InputTextModule} from 'primeng/primeng';
import {PasswordModule} from 'primeng/password';
import {ButtonModule} from 'primeng/button';
import {ReactiveFormsModule} from '@angular/forms';
import {GrowlModule} from 'primeng/growl';
import {MessageService} from 'primeng/components/common/messageservice';
import {KeyFilterModule} from 'primeng/keyfilter';
import { FuncionesComponent } from './funciones/funciones.component';
import { MenuBarComponent } from './menu-bar/menu-bar.component';
import {MenubarModule} from 'primeng/menubar';

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutes,
    HttpClientModule,
    CardModule,
    InputTextModule,
    PasswordModule,
    CalendarModule,
    ButtonModule,
    ReactiveFormsModule,
    GrowlModule,
    KeyFilterModule,
    MenubarModule
  ],
  declarations: [
    AppComponent,
    RegistroUsuarioComponent,
    LoginComponent,
    FuncionesComponent,
    MenuBarComponent
  ],
  providers: [
    HttpService,
    UsuarioService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
