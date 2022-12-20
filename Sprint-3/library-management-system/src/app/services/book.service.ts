import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Book from '../entity/book';

const BASE_URL = 'http://localhost:5000';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  saveBook(book: Book) {
    return this.http.post(BASE_URL + "/add/book", book);
  }

  getBooks(){
    return this.http.get(BASE_URL + "/allbooks");
  }

  deleteBook(book: any){
    return this.http.delete(BASE_URL + "/remove/" + book.bookID);
  }

  constructor(private http: HttpClient) { }
}
