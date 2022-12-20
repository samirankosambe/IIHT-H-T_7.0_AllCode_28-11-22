import { Component, OnInit } from '@angular/core';
import Book from 'src/app/entity/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  title: String = "Please fill the details below";

  book: Book = new Book();

  save(){
    if(this.book.name == ""){
      alert("Please add book name")
    }

    if(this.book.author == ""){
      alert("Please add book author")
    }
    if(isNaN(this.book.price) || this.book.price <= 0 ){
      alert("Please add book price")
    }
    if(this.book.genre == ""){
      alert("Please add book genre")
    }
    const observables = this.bookService.saveBook(this.book);
    observables.subscribe(
      (response: any) => {
        console.log(response);
      }, function (error) {
        console.log(error);
        alert("Something went wrong, please check again!");
      }
    )
  }

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
  }

}
