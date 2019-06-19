import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RobotDashboardComponent } from './robot-dashboard/robot-dashboard.component';
import { RobotRoutingModule } from './robot-routing.module';

@NgModule({
  declarations: [RobotDashboardComponent],
  imports: [
    CommonModule,
    RobotRoutingModule
  ]
})
export class RobotModule { }
