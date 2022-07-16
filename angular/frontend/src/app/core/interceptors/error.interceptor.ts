import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { MessageService } from 'primeng/api';
import { Router } from '@angular/router';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
    constructor(
        private messageService: MessageService,
        private router: Router) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => {
            if (err.status === 403) {
                this.messageService.add({ severity: 'warn', summary: 'Yetkisiz Erişim', detail: err.error.message });
                //this.router.navigate(['/login']);
            }

            if (err.status === 401) {
                // auto logout if 401 response returned from api
                this.messageService.add({ severity: 'error', summary: 'Hata Oluştu', detail: err.error.detail });
                //location.reload();
            }

            if (err.status === 400) {
                if (err.error) {
                    this.messageService.add({ severity: 'warn', summary: 'Uyarı', detail: err.error });
                }
            }
            if (err.status === 500 || err.status === 0) {
                this.messageService.add({ severity: 'error', summary: 'Hata Oluştu', detail: 'Üzgünüz! Sistemde beklenmedik bir hata oluştu. Lütfen tekrar deneyiniz' });
            }

            const error = err.error.message || err.statusText;
            return throwError(error);
        }));
    }
}
