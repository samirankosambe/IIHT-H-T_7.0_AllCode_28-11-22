import { Component, OnInit } from '@angular/core';
import User from 'src/app/Entity/user';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  title: String = "Please fill the form below";

  user: User = new User();

  save() {
    const observables = this.userService.saveUser(this.user);
    observables.subscribe(
      (response: any) => {
        console.log(response);
      }, function (error) {
        console.log(error);
        alert("Something went wrong, please check again!");
      }
    )
  }
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

}
