import { NgModule } from '@angular/core';
import { DoctorDashboardComponent } from './doctor-dashboard/doctor-dashboard.component';
import { Routes, RouterModule } from '@angular/router';
import { DoctorLayoutComponent } from '../layout/doctor-layout/doctor-layout.component';
import { PatientsManagementComponent } from './patients-management/patients-management.component';
import { RobotManagementDoctorComponent } from './robot-management-doctor/robot-management-doctor.component';

const routes: Routes = [
  { path: 'doctor-dashboard', component: DoctorLayoutComponent, children:[
    { path: '', component: DoctorDashboardComponent},
    { path: 'patients-management', component: PatientsManagementComponent},
    { path: 'robot-management-doctor', component: RobotManagementDoctorComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DoctorRoutingModule { }
