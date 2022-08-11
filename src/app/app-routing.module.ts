import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './generales/login/login.component';

const routes: Routes = [
  {path: 'login',component: LoginComponent},
  {path: 'productos', loadChildren: () => import('./productos/productos.module').then(m => m.ProductosModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
