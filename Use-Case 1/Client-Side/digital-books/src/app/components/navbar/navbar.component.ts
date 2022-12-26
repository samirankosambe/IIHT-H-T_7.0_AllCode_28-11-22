import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtClientService } from 'src/app/services/jwt-client.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  username: string;

  navSelected: string = location.href.split('/')[location.href.split('/').length - 1];
  public isLoggedIn() {
    this.username = this.jwtService.getUsername();
    return this.jwtService.getToken();
  }

  public logout() {
    window.sessionStorage.clear();
    this.router.navigate(['']);
  }

  constructor(private router: Router,
    public userService: UserService,
    private jwtService: JwtClientService) { }

  ngOnInit(): void {
  }

}
