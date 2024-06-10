import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { HotelsComponent } from './hotels/hotels.component';
import { LoginComponent } from './login/login.component';
import { AddRoomComponent } from './add-room/add-room.component';

@NgModule({
  declarations: [
    AppComponent,
    HotelsComponent,
    LoginComponent,
    AddRoomComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [
    AppComponent,

  ]
})
export class AppModule { }
