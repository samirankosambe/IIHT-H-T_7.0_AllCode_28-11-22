import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Components/home/home.component';
import { UserformComponent } from './Components/userform/userform.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './Components/navbar/navbar.component';
import {MatListModule} from '@angular/material/list';
import {MatMenuModule} from '@angular/material/menu';
import { AboutComponent } from './Components/about/about.component';
import { ContactUsComponent } from './Components/contact-us/contact-us.component';
import {HttpClientModule} from '@angular/common/http';
import { RegUsersComponent } from './Components/reg-users/reg-users.component'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserformComponent,
    NavbarComponent,
    AboutComponent,
    ContactUsComponent,
    RegUsersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatListModule,
    MatMenuModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
