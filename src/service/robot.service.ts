import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { RobotDTO } from 'src/dto/robotdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UserService extends AbstractService<RobotDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'Robot';
  }

  login(loginDTO: LoginDTO): Observable<RobotDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)
  }

}