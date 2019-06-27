import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { AdminMenuComponent } from './admin-layout/admin-menu/admin-menu.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';
import { RobotLayoutComponent } from './robot-layout/robot-layout.component';
import { RobotMenuComponent} from './robot-layout/robot-menu/robot-menu.component';
import { DoctorLayoutComponent } from './doctor-layout/doctor-layout.component';
import { DoctorMenuComponent } from './doctor-layout/doctor-menu/doctor-menu.component';
import { PatientLayoutComponent } from './patient-layout/patient-layout.component';
import { PatientMenuComponent } from './patient-layout/patient-menu/patient-menu.component';

/**
 * Modulo di layout. Viene caricato nel rputer outlet padre e poi 
 * non viene più ricaricato. Quando clicchiamo su un link ricarichiamo solo l'outlet
 * che sta dentro AdminLayoutComponent
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 */
@NgModule({
  declarations: [AdminLayoutComponent, AdminMenuComponent, HeaderComponent, RobotLayoutComponent, RobotMenuComponent, DoctorLayoutComponent, DoctorMenuComponent, PatientLayoutComponent, PatientMenuComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class LayoutModule { }
