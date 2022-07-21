import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PysService } from "../../shared/service/pys.service";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router, private service: PysService) {
    service.logoutApi();
  }

  ngOnInit(): void {
  }

}
