import { Component, OnInit } from '@angular/core';
import { RobotDTO } from 'src/dto/robotdto';
import { RobotService } from 'src/service/robot.service';

@Component({
  selector: 'app-robot-management-doctor',
  templateUrl: './robot-management-doctor.component.html',
  styleUrls: ['./robot-management-doctor.component.css']
})
export class RobotManagementDoctorComponent implements OnInit {

  robots: RobotDTO[];
  robottoinsert: RobotDTO = new RobotDTO();

  constructor(private service: RobotService) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.service.getAll().subscribe(users => this.robots = users);
  }

  delete(robot: RobotDTO) {
    this.service.delete(robot.id).subscribe(() => this.getAll());
  }

  update(robot: RobotDTO) {
    this.service.update(robot).subscribe(() => this.getAll());
  }

  insert(robot: RobotDTO) {
    this.service.insert(robot).subscribe(() => this.getAll());
  }

  clear(){
    this.robottoinsert = new RobotDTO();
  }
}
