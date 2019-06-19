import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { DoctorLayoutComponent } from '../layout/doctor-layout/doctor-layout.component';
import { DoctorDashboardComponent } from './doctor-dashboard/doctor-dashboard.component';

const routes: Routes = [
  { path: 'doctor-dashboard', component: DoctorLayoutComponent, children:[
    { path: '', component: DoctorDashboardComponent}
  ]}
];


@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DoctorRoutingModule { }
