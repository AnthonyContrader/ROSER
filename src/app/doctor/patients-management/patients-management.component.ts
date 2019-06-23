import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';

@Component({
  selector: 'app-patients-management',
  templateUrl: './patients-management.component.html',
  styleUrls: ['./patients-management.component.css']
})
export class PatientsManagementComponent implements OnInit {

  users: UserDTO[];
  usertoinsert: UserDTO = new UserDTO();

  constructor(private service: UserService) { }

  ngOnInit() {
    this.getUserByType("USER");
  }

  getUsers() {
    this.service.getAll().subscribe(users => this.users = users);
  }

  getUserByType(userType: String)
  {
    this.service.getUserByType(userType).subscribe(users => this.users = users);
  }

  delete(user: UserDTO) {
    this.service.delete(user.id).subscribe(() => this.getUserByType("USER"));
  }

  update(user: UserDTO) {
    this.service.update(user).subscribe(() => this.getUserByType("USER"));
  }

  insert(user: UserDTO) {
    this.service.insert(user).subscribe(() => this.getUserByType("USER"));
  }

  clear(){
    this.usertoinsert = new UserDTO();
  }

}
