import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from '../app.component';
import { LoginComponent } from './login.component';



@NgModule({
  declarations: [ LoginComponent],
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class LoginModule { }
