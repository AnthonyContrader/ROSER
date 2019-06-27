import { NgModule } from '@angular/core';
import {PatientDashboardComponent} from './patient-dashboard/patient-dashboard.component';
import { PatientLayoutComponent } from '../layout/patient-layout/patient-layout.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'patient-dashboard', component: PatientLayoutComponent, children:[
    { path: '', component: PatientDashboardComponent},
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PatientRoutingModule { }
