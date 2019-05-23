import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule , routingComponent } from './app-routing.module';
import { LoginComponent } from './book/login/login.component';
import {GuestBookService} from './book/guestbook.service';
import { HomeComponent } from './book/Home/home.component';
import { AdminComponent } from './book/admin/admin.component';
import { GuestComponent } from './book/guestpage/guest.component';
import { LogoutComponent } from './book/logout/logout.component';
import { SignUpComponent } from './book/signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    routingComponent,
    LoginComponent,
    AdminComponent,
    GuestComponent,
    LogoutComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [GuestBookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
