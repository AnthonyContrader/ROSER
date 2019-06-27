import { Component, OnInit } from '@angular/core';
import { SensordataDTO } from 'src/dto/sensordatadto';
import { RobotService } from 'src/service/robot.service';
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
  constructor(private service:RobotService) { }

  ngOnInit() {
    this.robot = JSON.parse( localStorage.getItem("currentUser"));
    
    
  }

}
