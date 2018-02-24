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
import {CalendarModule, CarouselModule, CheckboxModule, InputTextModule, OverlayPanelModule} from 'primeng/primeng';
import {PasswordModule} from 'primeng/password';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {GrowlModule} from 'primeng/growl';
import {MessageService} from 'primeng/components/common/messageservice';
import {KeyFilterModule} from 'primeng/keyfilter';
import { PeliculasComponent } from './peliculas/peliculas.component';
import { MenuBarComponent } from './menu-bar/menu-bar.component';
import {MenubarModule} from 'primeng/menubar';
import {PeliculaService} from './services/pelicula.service';
import {DataGridModule} from 'primeng/datagrid';
import {SessionService} from './services/session.service';
import {DialogModule} from 'primeng/dialog';
import {StepsModule} from 'primeng/steps';
import {FuncionService} from './services/funcion.service';
import {TableModule} from 'primeng/table';

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
    MenubarModule,
    CarouselModule,
    DialogModule,
    OverlayPanelModule,
    StepsModule,
    TableModule,
    FormsModule,
    CheckboxModule
  ],
  declarations: [
    AppComponent,
    RegistroUsuarioComponent,
    LoginComponent,
    PeliculasComponent,
    MenuBarComponent
  ],
  providers: [
    HttpService,
    UsuarioService,
    MessageService,
    PeliculaService,
    SessionService,
    FuncionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
