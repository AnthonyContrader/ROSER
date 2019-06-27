import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { UserDTO } from 'src/dto/userdto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((token : any) => {
      localStorage.setItem("currentUser", JSON.stringify({ "usertype": token.id_token }));

      this.service.userLogged(this.loginDTO.username).subscribe((user:UserDTO)=>{

      if (user != null) {
        localStorage.setItem('currentUser', JSON.stringify(user));
        console.log(user);
        if(user.usertype == 0) {
          this.router.navigate(['/admin-dashboard']);
        }
        if(user.usertype == 1) {
          this.router.navigate(['/user-dashboard']);
        }
        if(user.usertype == 2) {
          this.router.navigate(['/doctor-dashboard']);
        }
        if(user.usertype == 3) {
          this.router.navigate(['/robot-dashboard']);
        }
        
      }
    });
  });
  }
}
