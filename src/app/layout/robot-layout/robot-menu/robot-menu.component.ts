import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-robot-menu',
  templateUrl: './robot-menu.component.html',
  styleUrls: ['./robot-menu.component.css']
})
export class RobotMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isRobotCollapsed = false;
  isSensordataCollapsed = false;
  

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  robotscollapse() {
    if (this.isRobotCollapsed === false) {
      this.isRobotCollapsed = true;
    } else { this.isRobotCollapsed = false; }
  }
  sensordatacollapse() {
    if (this.isSensordataCollapsed === false) {
      this.isSensordataCollapsed = true;
    } else { this.isSensordataCollapsed = false; }
  }
}
