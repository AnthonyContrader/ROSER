import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { routerNgProbeToken } from '@angular/router/src/router_module';
import { Router } from '@angular/router';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: UserDTO;

  constructor(private router: Router) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  doctormanagement () {
    this.router.navigate[("/")];
  }

}
