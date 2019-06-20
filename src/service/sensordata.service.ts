import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { SensordataDTO } from 'src/dto/sensordatadto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SensordataService extends AbstractService<SensordataDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'sensordata';
  }

}
