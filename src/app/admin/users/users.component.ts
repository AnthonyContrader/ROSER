import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit{

  users: UserDTO[];
  usertoinsert: UserDTO = new UserDTO();

  constructor(private service: UserService) { }

  ngOnInit() {
    this.getAll();
  }

  getAll(){
    this.service.getAll().subscribe(users => this.users = users);
  }

  getUserByType(userType: String)
  {
    this.service.getUserByType(userType).subscribe(users => this.users = users);
  }

  delete(user: UserDTO) {
    this.service.delete(user.id).subscribe(() => this.getUserByType("DOCTOR"));
  }

  update(user: UserDTO) {
    this.service.update(user).subscribe(() => this.getUserByType("DOCTOR"));
  }

  insert(user: UserDTO) {
    this.service.insert(user).subscribe(() => this.getUserByType("DOCTOR"));
  }

  clear(){
    this.usertoinsert = new UserDTO();
  }
}
