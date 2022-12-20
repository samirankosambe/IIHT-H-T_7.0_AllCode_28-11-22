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
