import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DoctorDashboardComponent } from './doctor-dashboard/doctor-dashboard.component';
import { DoctorRoutingModule } from './doctor-routing.module';
import { PatientsManagementComponent } from './patients-management/patients-management.component';
import { FormsModule } from '@angular/forms';
import { RobotManagementDoctorComponent } from './robot-management-doctor/robot-management-doctor.component';

@NgModule({
  declarations: [ DoctorDashboardComponent, PatientsManagementComponent, RobotManagementDoctorComponent],
  imports: [
    CommonModule,
    DoctorRoutingModule,
    FormsModule
  ]
})
export class DoctorModule { }
