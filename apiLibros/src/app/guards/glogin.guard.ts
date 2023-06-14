import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import {LoginServicesService} from '../servicios/login-services.service';

@Injectable({
  providedIn: 'root'
})
export class GloginGuard implements CanActivate {

  constructor(  private router: Router, private loginServicesService:LoginServicesService) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if (this.loginServicesService.isAuthenticate()) {
        return true;
      }else{
        this.router.navigate(['/login']);
        return false;
      }

  }

}
