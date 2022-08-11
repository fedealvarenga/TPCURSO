import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
type User = {
  nombreDeUsuario: string | null;
  password: string | null;
};
@Component({
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user={
    nombreDeUsuario: null,
    password: null
  }
  constructor(
    private router: Router,
  ) { }

  ngOnInit(): void {
  }

  onSubmit(user: User ) {
      fetch('http://localhost:8080/usuarios/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-type': 'application/json'
        },

        body: JSON.stringify(user)
      }).then(response => response.json()) // te formatea el Json deja de ser solo en una linea
      .then(data => this.guardar(data))
      .catch(error => console.log(error));
    }
  guardar(idusuario : number){
          localStorage.setItem('id',String(idusuario)); //localStorege.getItem('id')
          this.irAProductos();
  }
  public irAProductos(){
    this.router.navigate(['/productos']);
  }
}
