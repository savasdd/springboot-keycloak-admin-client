import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Kullanici } from "../shared/model/Kullanici";
import { PysService } from "../shared/service/pys.service";


@Component({
  templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit {
  kullanici: Kullanici;
  value1: string;

  public constructor(private router: Router, private service: PysService) {
  }


  ngOnInit(): void {
    this.kullanici = { username: null, password: null }
  }

  login() {
    this.service.loginApi(this.kullanici.username, this.kullanici.password);
    this.router.navigate(['/home']);
  }
}
