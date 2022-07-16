import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SessionStorageService } from 'angular-web-storage';


@Injectable()
export class BearerAuthInterceptor implements HttpInterceptor {
    constructor(public sessionStorage: SessionStorageService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add header with bearer auth credentials if user is logged in and request is to the api url
        const token = this.sessionStorage.get("BearerAuth");
        const isApiUrl = request.url.startsWith(environment.apiUrl);
        if (isApiUrl && token) {
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${token}`,
                }
            });
        }
        
        return next.handle(request);
    }
}
