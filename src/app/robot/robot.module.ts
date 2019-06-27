import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RobotRoutingModule } from './robot-routing.module';
import { RobotDashboardComponent } from './robot-dashboard/robot-dashboard.component';
import { ParametersComponent } from './parameters/parameters.component';

@NgModule({
  declarations: [RobotDashboardComponent, ParametersComponent],
  imports: [
    CommonModule,
    RobotRoutingModule,
    FormsModule
  ]
})
export class RobotModule { }
