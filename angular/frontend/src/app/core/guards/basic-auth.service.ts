import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { SessionStorageService } from 'angular-web-storage';


@Injectable({
    providedIn: 'root'
})
export class BearerAuthService implements CanActivate {
    constructor(
        private router: Router,
        private sessionStorage: SessionStorageService
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const currentUser = this.sessionStorage.get('UserModel');
        if (currentUser) {
            return true;
        } else {
            this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
            return false;
        }
    }
}
