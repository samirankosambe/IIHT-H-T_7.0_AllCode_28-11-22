import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from 'src/app/entity/book';
import { JwtClientService } from 'src/app/services/jwt-client.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book: Book;
  category: string;
  title: string;
  author: string;
  price: number;
  publisher: string;
  active: string;
  content: string;
  logo: string;
  releaseDate: Date;
  isBookCreated: boolean=false;
 
  validate(addBookForm:NgForm) {
    if(addBookForm.valid){
      this.addBook(addBookForm);
    }else{
      alert("Please fill all the values");
    }
  }


  addBook(addBookForm:NgForm){
    this.book =addBookForm.value;
   // this.book.logo=this.base64;
    const promise = this.userService.addBook(parseInt(this.jwtService.getUserid()),this.book);
    promise.subscribe((response:any)=>{
      //console.log(response);
      this.isBookCreated = true;
      alert('Book is added succesfully.');
       this.router.navigateByUrl('/', { skipLocationChange: true }).then(()=>{
         this.router.navigate(["addBook"]);
       });
    },function(error){
      console.log(error);
      alert("Something went wrong, please try again later");
    });
  }


  constructor(private jwtService: JwtClientService,
    private userService:UserService,
    private router: Router) {}

  ngOnInit(): void {
    
  }

}
