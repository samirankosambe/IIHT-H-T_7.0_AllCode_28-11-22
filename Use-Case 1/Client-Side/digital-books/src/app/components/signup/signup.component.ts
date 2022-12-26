import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  form: any = {
    username: null,
    email: null,
    password: null
  };
  errorMessage: string = '';
  isSignUpSuccess: boolean = false;
  isSignUpFailed: boolean = false;

  validate(signupForm) {
    if (signupForm.valid) {
      this.signup(signupForm);
    }
  }

  signup(signupForm: NgForm) {
    const promise = this.userService.signupUser(signupForm.value);

    promise.subscribe((response) => {
      this.isSignUpSuccess = true;
      this.errorMessage = '';
      signupForm.resetForm();
      this.router.navigate(['login'])

    }, (error) => {
      console.log(error);
      this.isSignUpFailed = true;
      if (error.status == 403) {
        this.errorMessage = error.error;
      }
      alert('something is wrong, try again');

    });
  }
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }


}
