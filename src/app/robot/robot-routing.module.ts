import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { RobotLayoutComponent } from '../layout/robot-layout/robot-layout.component';
import { RobotDashboardComponent } from './robot-dashboard/robot-dashboard.component';
import { ParametersComponent } from './parameters/parameters.component';

const routes :Routes  = [
  { path: 'robot-dashboard', component: RobotLayoutComponent, children:[
    { path: '', component: RobotDashboardComponent},
    { path: 'parameters', component: ParametersComponent}
  ]}
];

@NgModule({
  declarations: [],
  imports: [
    
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class RobotRoutingModule { }
