import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  mensaje:any="";



  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  submitForm() {
    if (this.username === 'admin' && this.password== 'prueba') {
      // Aquí puedes redirigir a la siguiente pantalla o realizar otras acciones
      console.log('Inicio de sesión exitoso');
      this.router.navigate(['/autores']);
    } else {
      console.log('Usuario o contraseña inválidos');
      this.mensaje="Usuario o contraseña inválidos";
    }
  }

}
