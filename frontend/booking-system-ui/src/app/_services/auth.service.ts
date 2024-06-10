import { Injectable } from '@angular/core';
import {AxiosService} from "./axios.service";
import {Router} from "@angular/router";
import Swal from 'sweetalert2';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedIn = new BehaviorSubject<boolean>(false);
  loggedIn$ = this.loggedIn.asObservable();

  constructor(private axios: AxiosService, private router: Router) { }

  login(email: string, password: string) {
    this.axios.request(
      "POST",
      "/api/v1/auth",
      {
        email: email,
        password: password
      }).then(resp => {
        this.loggedIn.next(true);
      this.axios.setAuthTokenAndRole(resp.data.token, resp.data.role, resp.data.id)
      if (resp.data.role === "ADMIN") {
        this.router.navigate(["add-room"]);
      } else {
        this.successAlert();
      }
    }).catch(error => {
      this.errorAlert();
    })
  }

  successAlert() {
    Swal.fire({
      title: "Giriş Başarılı",
      html: "Giriş başarılı anasayfaya yönlendiriliyosunuz...",
      icon: 'success',
      timer: 3000,
      timerProgressBar: true,
    }).then((result) => {
      if (result.dismiss === Swal.DismissReason.timer) {
        this.router.navigate(["hotels"]);
      }
    });
  }

  errorAlert() {
    Swal.fire({
      title: "Giriş Başarısız",
      html: "Giriş başarısız giriş bilgilerini tekrar giriniz...",
      icon: 'error',
    });
  }
}
