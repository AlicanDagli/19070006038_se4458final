import { Component } from '@angular/core';
import {LocationService} from "./_services/location.service";
import {Location} from "./_models/location";
import {Router} from "@angular/router";
import {AuthService} from "./_services/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'booking-system-ui';

  loggedIn = false;

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit() {
    this.authService.loggedIn$.subscribe(loggedIn => {
      this.loggedIn = loggedIn;
    })
  }

  login() {
    this.router.navigate(['/login']);
  }

  home() {
    this.router.navigate(['/hotels']);
  }
}
