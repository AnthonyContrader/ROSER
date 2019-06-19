import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login/login.module';
import { HttpClientModule } from '@angular/common/http';
import { LayoutModule } from './layout/layout.module';
import { AdminModule } from './admin/admin.module';

import { UserRoutingModule } from './user/user-routing.module';
import { UserModule} from './user/user.module';

import { DoctorDashboardComponent } from './doctor/doctor-dashboard/doctor-dashboard.component';
import { DoctorRoutingModule } from './doctor/doctor-routing.module';
import { DoctorLayoutComponent } from './layout/doctor-layout/doctor-layout.component';

import { RobotDashboardComponent } from './robot/robot-dashboard/robot-dashboard.component';
import { RobotRoutingModule } from './robot/robot-routing.module';
import { RobotLayoutComponent } from './layout/robot-layout/robot-layout.component';


/** 
 * Modulo principale dell'applicazione. Qui vengono importati i moduli secondari. L'UNICA component
 * da dichiare qui è l'AppComponent, tutte le altre devono essere dichiarate nel loro modulo e questo importato
 * qui.
 * 
 * @author Vittorio Valent
*/
@NgModule({
  declarations: [
    AppComponent,
    DoctorDashboardComponent,
    DoctorLayoutComponent,
    RobotDashboardComponent,
    RobotLayoutComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginModule,
    HttpClientModule,
    LayoutModule,
    AdminModule,
    UserModule,
    UserRoutingModule,
    DoctorRoutingModule,
    RobotRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
