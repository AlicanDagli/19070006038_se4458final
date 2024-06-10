import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../_services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(private formBuilder: FormBuilder, private authService: AuthService) { }

  signInForm: FormGroup = this.formBuilder.group({
    email: ['', Validators.required],
    password: ['', Validators.required]
  })

  signIn(): void {
    if (this.signInForm.valid) {
      this.authService.login(this.signInForm.value.email, this.signInForm.value.password);
    }
  }

}
