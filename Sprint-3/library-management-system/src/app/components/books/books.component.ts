import { Component, OnInit } from '@angular/core';
import Book from 'src/app/entity/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[] = [];

  constructor(private bookService: BookService) { }

  deleteRow(book: any, index: any) {
    const observables = this.bookService.deleteBook(book);
    observables.subscribe((response: any) => {
        console.log(response);
        this.books.splice(index, 1);
    })
  }

  ngOnInit(): void {
    const promise = this.bookService.getBooks();
    promise.subscribe((response) =>{
      console.log(response);
      this.books = response as Book[];
    })
  }
}
