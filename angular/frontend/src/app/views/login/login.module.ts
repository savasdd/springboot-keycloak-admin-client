import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from '../login/login.component';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import { LogoutComponent } from './logout/logout.component';

@NgModule({
    imports: [
        CommonModule,
        InputTextModule,
        FormsModule
    ],
    declarations: [LoginComponent, LogoutComponent],
    exports: [LoginComponent],
})
export class LoginModule { }