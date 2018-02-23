import { Component, OnInit } from '@angular/core';
import {UsuarioService} from '../services/usuario.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MessageService} from 'primeng/components/common/messageservice';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {
  usuarioForm: FormGroup;

  constructor(private fb: FormBuilder,
              private usuarioService: UsuarioService,
              private messageService: MessageService,
              private router: Router) { }

  ngOnInit() {
    this.usuarioForm = this.fb.group({
      username: [null, [Validators.required, Validators.minLength(4)]],
      clave: [null, [Validators.required, Validators.minLength(6)]],
      nombres: [null, [Validators.required, Validators.minLength(3)]],
      apellidos: [null, [Validators.required, Validators.minLength(3)]],
      identificacion: [null, [Validators.required, Validators.minLength(10), Validators.maxLength(13)]],
      fechaNacimiento: [null, Validators.required]
    });
  }

  registrar(){
    this.usuarioService.registrar(this.usuarioForm.value)
      .subscribe(value => {
        this.messageService.add({severity:'success', summary:'Usuario', detail:'Usuario creado exitosamente'});
        this.router.navigateByUrl('/login')
      });
  }
}
