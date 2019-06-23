import { Component, OnInit } from '@angular/core';
import { RobotDTO } from 'src/dto/robotdto';
import { RobotService } from 'src/service/robot.service';
import { UserService } from 'src/service/user.service';

@Component({
  selector: 'app-robot-managment',
  templateUrl: './robot-managment.component.html',
  styleUrls: ['./robot-managment.component.css']
})
export class RobotManagmentComponent implements OnInit {

  robots: RobotDTO[];
  robottoinsert: RobotDTO = new RobotDTO();

  constructor(private service: RobotService, private userService: UserService) { }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.service.getAll().subscribe(users => this.robots = users);
  }

  delete(robot: RobotDTO) {
    this.userService.deleteRobot(robot).subscribe();
    this.service.delete(robot.id).subscribe(() => this.getAll());
  }

  update(robot: RobotDTO) {
    this.service.update(robot).subscribe(() => this.getAll());
  }

  insert(robot: RobotDTO) {
    this.robottoinsert.ownername = "No Owner";
    this.robottoinsert.ownersurname = "No Owner";

    this.userService.insertRobot(robot).subscribe();
    this.service.insert(robot).subscribe(() => this.getAll());
  }

  clear(){
    this.robottoinsert = new RobotDTO();
  }
}
