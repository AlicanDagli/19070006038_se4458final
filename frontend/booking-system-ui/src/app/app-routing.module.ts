import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {HotelsComponent} from "./hotels/hotels.component";
import {AddRoomComponent} from "./add-room/add-room.component";

const routes: Routes = [
  { path: '', redirectTo: 'hotels', pathMatch: 'full' },
  { path: 'hotels', component: HotelsComponent},
  { path: 'login', component: LoginComponent},
  { path: 'add-room', component: AddRoomComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
