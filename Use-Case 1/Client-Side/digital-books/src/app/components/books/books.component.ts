import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from 'src/app/entity/book';
import { JwtClientService } from 'src/app/services/jwt-client.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  book: Book;
  books: Book[];
  editBookStatus: boolean = false;
  editBookFlg: boolean = false;
  isBookEdited: boolean = false;
  isBookFound: boolean = false;
  errorMessage: string='';

  editBook(authorId,bookId){
    this.editBookFlg = true;
    this.getBookData(bookId);
  }

  validate(editBookForm:NgForm) {
    if(editBookForm.valid){
      this.submitEditedBook(this.book);
    }else{
      alert("Please fill all the values");
    }
  }

  getBookData(bookId:number){
    const promise = this.userService.getBookByID(bookId);
    promise.subscribe((response:any)=>{
      //console.log(response);
      this.book = response;
    },function(error){
      console.log(error);
      alert("Something went wrong, please try again later");
    });
  }

  submitEditedBook(book:Book){
   // this.book =editBookForm.value;
    const promise = this.userService.editBook(parseInt(this.jwtService.getUserid()),book.bookid,book);
    promise.subscribe((response:any)=>{
     // console.log(response);
      this.isBookEdited = true;
      this.editBookFlg = false;
     // editBookForm.resetForm();
    // window.location.reload();
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(()=>{
      this.router.navigate(["getAuthorBooks"]);
    });
    },function(error){
      console.log(error);
      alert("Something went wrong, please try again later");
    });
  }

  changeBookStatus(authorID:string,bookId:number){
    const promise = this.userService.changeStatusOfBook(parseInt(authorID),bookId);
    promise.subscribe((response)=>{
      //console.log(response);
       this.router.navigateByUrl('/', { skipLocationChange: true }).then(()=>{
        this.router.navigate(["getAuthorBooks"]);
      });
    },(error)=>{
      console.log(error);
      
    })
  }

  constructor(private userService:UserService,
    public jwtService: JwtClientService,
    private router:Router) {
      const promise = this.userService.getAllAuthorBooks(this.jwtService.getUsername());
      promise.subscribe((response:any)=>{
        if(response.length > 0){
          this.books = response;
          this.isBookFound = true;
        }else{
          this.errorMessage = 'No Books Found';
          this.isBookFound = false;
        }
        //console.log(response);
      },(error)=>{
          console.log(error);
      });
   }

  ngOnInit(): void {
  }

}
