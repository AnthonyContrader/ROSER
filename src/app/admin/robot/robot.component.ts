import { Component, OnInit } from '@angular/core';
import { RobotService } from 'src/service/robot.service';
import { RobotDTO } from 'src/dto/robotdto';

@Component({
  selector: 'app-users',
  templateUrl: './robot.component.html',
  styleUrls: ['./robot.component.css']
})
export class RobotComponent implements OnInit {

  robot: RobotDTO[];
  robottoinsert: RobotDTO = new RobotDTO();

  constructor(private service: RobotService) { }

  ngOnInit() {
    this.getRobot();
  }

  getRobot() {
    this.service.getAll().subscribe(robot => this.robot = robot);
  }

  delete(robot: RobotDTO) {
    this.service.delete(robot.id).subscribe(() => this.getRobot());
  }

  update(robot: RobotDTO) {
    this.service.update(robot).subscribe(() => this.getRobot());
  }

  insert(robot: RobotDTO) {
    this.service.insert(robot).subscribe(() => this.getRobot());
  }

  clear(){
    this.robottoinsert = new RobotDTO();
  }
}
