import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UsuarioService} from '../services/usuario.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder,
              private usuarioService: UsuarioService,
              private router: Router) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      username: [null, Validators.required],
      clave: [null, Validators.required]
    });
  }

  login(){
    let usuarioLogin = this.loginForm.value;
    this.usuarioService.login(usuarioLogin).subscribe(value => {
      localStorage.setItem('cine-id', value.id);
      localStorage.setItem('cine-nombres', value.nombres + ' ' + value.apellidos);
      localStorage.setItem('cine-autorizacion', `Basic ${btoa(usuarioLogin.username + ':' + usuarioLogin.clave)}`);
      localStorage.setItem('cine-rol', value.rol);
      this.router.navigateByUrl('');
    });
  }
}
