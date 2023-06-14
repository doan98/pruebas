import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class LoginServicesService {

  private isAuthenticated: boolean = false;

  constructor() { }


  login() {

   this.isAuthenticated = true;
  }

  logout(): void {

    this.isAuthenticated = false;

  }

  isAuthenticate(): boolean {
    return this.isAuthenticated;

  }
}
