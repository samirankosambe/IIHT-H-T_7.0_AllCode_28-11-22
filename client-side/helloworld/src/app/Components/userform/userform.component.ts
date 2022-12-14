import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  title:String = "Please fill the form below";

  firstname:String = "";
  lastname:String = "";
  age=0;
  gender:String = "male";
  email:String="";

  save(){
    console.log("Hello "+this.firstname+" "+this.lastname);
    console.log("your email address is "+this.email); 
  }
  constructor() { }

  ngOnInit(): void {
  }

}
