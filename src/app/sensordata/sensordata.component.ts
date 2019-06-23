import { Component, OnInit } from '@angular/core';
import { SensordataService } from 'src/service/sensordata.service';
import { SensordataDTO } from 'src/dto/sensordatadto';

@Component({
  selector: 'app-users',
  templateUrl: './sensordata.component.html',
  styleUrls: ['./sensordata.component.css']
})
export class SensordataComponent implements OnInit {

  sensordata: SensordataDTO[];
  sensordatatoinsert: SensordataDTO = new SensordataDTO();

  constructor(private service: SensordataService) { }

  ngOnInit() {
    this.getSensordata();
  }

  getSensordata() {
    this.service.getAll().subscribe(sensordata => this.sensordata = sensordata);
  }

  delete(sensordata: SensordataDTO) {
    this.service.delete(sensordata.id).subscribe(() => this.getSensordata());
  }

  update(sensordata: SensordataDTO) {
    this.service.update(sensordata).subscribe(() => this.getSensordata());
  }

  insert(sensordata: SensordataDTO) {
    this.service.insert(sensordata).subscribe(() => this.getSensordata());
  }

  clear(){
    this.sensordatatoinsert = new SensordataDTO();
  }
}
