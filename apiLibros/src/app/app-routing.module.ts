import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import {AutoresComponent } from './autores/autores.component';



const routes: Routes = [

  {path: '', component:LoginComponent},
  { path: 'autores', component: AutoresComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
