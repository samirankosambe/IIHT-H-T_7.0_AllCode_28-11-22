import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtResponse } from 'src/app/entity/jwt-response';
import { User } from 'src/app/entity/user';
import { JwtClientService } from 'src/app/services/jwt-client.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  role: string = '';
  jwtResponse: JwtResponse;
  errorMessage: string = '';
  isLoggedIn: boolean;
  isLoginFailed: boolean;

  validate(loginForm) {
    if (loginForm.valid) {
      this.login(loginForm);
    }
  }

  login(loginForm) {
    const promise = this.userService.loginUser(loginForm.value);
    promise.subscribe((response: any) => {
      this.isLoggedIn = true;
      this.errorMessage = "";
      this.jwtResponse = response;
      this.jwtService.setToken(response.jwtToken);
      this.jwtService.setUserid(response.user.userid);
      this.jwtService.setUsername(response.user.username);
      this.jwtService.setRole(response.user.role);
      this.router.navigate(['search']);

    }, (error) => {
      this.isLoginFailed = true;
      console.log(error);
      if (error.status == 403) {
        this.errorMessage = "Please provide valid credentials";
      }

    })
  }
  constructor(private userService: UserService,
    private router: Router,
    private jwtService: JwtClientService) { }

  ngOnInit(): void {
    if (this.jwtService.getToken()) {
      this.isLoggedIn = true;
      this.role = this.jwtService.getRole();
    }
  }

}
