import { Component, OnInit } from '@angular/core';
import { SensordataDTO } from 'src/dto/sensordatadto';
import { RobotService } from 'src/service/robot.service';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';
/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-robot-dashboard',
  templateUrl: './robot-dashboard.component.html',
  styleUrls: ['./robot-dashboard.component.css']
})
export class RobotDashboardComponent implements OnInit {

  sensordata: SensordataDTO;
  robot : UserDTO;
  list : String[];
  constructor(private service:RobotService,private router:Router) { }

  ngOnInit() {
    this.robot = JSON.parse( sessionStorage.getItem("currentUser")) as UserDTO;
    this.service.getParamenter(this.robot).subscribe(data => {
      this.sensordata = data;
      console.log(data);
    });
    
  }

}
