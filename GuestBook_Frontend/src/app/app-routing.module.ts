import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuestComponent } from './book/guestpage/guest.component';
import { AdminComponent } from './book/admin/admin.component';
import { LoginComponent } from './book/login/login.component';
import { HomeComponent } from './book/Home/home.component';
import { LogoutComponent } from './book/logout/logout.component';
import { SignUpComponent } from './book/signup/signup.component';


const routes : Routes = [
{ path : 'guest', component: GuestComponent},
{ path : 'admin', component: AdminComponent},
{ path : 'login/:userType', component: LoginComponent},
{ path : 'logout', component: HomeComponent},
{ path : 'signup', component: SignUpComponent},
{ path : 'loginasadmin/:userType', component: LoginComponent},
{ path : '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
export const routingComponent = [GuestComponent,AdminComponent]