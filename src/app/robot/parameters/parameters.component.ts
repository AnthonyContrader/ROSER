import { Component, OnInit } from '@angular/core';
import { RobotService } from 'src/service/robot.service';
import { SensordataDTO } from 'src/dto/sensordatadto';
import { UserDTO } from 'src/dto/userdto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-parameters',
  templateUrl: './parameters.component.html',
  styleUrls: ['./parameters.component.css']
})
export class ParametersComponent implements OnInit {

  sensordata: SensordataDTO;
  robot : UserDTO;
  list : Array<String>;
  constructor(private service:RobotService,private router:Router) { }

  ngOnInit() {
    this.robot = JSON.parse( sessionStorage.getItem("currentUser"));
    this.service.getParameter(this.robot).subscribe(data => {this.sensordata = data;
      console.log(data); });
      this.service.getMedia(this.sensordata).subscribe(data => {
        this.list = data;
      });
  }
}
