import { Component, OnInit } from '@angular/core';
import { RobotDTO } from 'src/dto/robotdto';
import { RobotService } from 'src/service/robot.service';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';

@Component({
  selector: 'app-robot-management-doctor',
  templateUrl: './robot-management-doctor.component.html',
  styleUrls: ['./robot-management-doctor.component.css']
})
export class RobotManagementDoctorComponent implements OnInit {

  robots: RobotDTO[];
  users: UserDTO[];
  robottoinsert: RobotDTO = new RobotDTO();

  constructor(private service: RobotService, private userService: UserService) { }

  ngOnInit() {
    this.getAll();
    this.getUserByType("USER");
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
  
  getUserByType(userType: String)
  {
    this.userService.getUserByType(userType).subscribe(users => this.users = users);
  }

  clear(){
    this.robottoinsert = new RobotDTO();
  }
}
