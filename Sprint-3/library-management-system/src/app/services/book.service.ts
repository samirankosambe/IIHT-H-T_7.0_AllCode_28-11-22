import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL = 'http://localhost:5000/users';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  saveBook(book: {
    name: String,
    author: String,
    price: number,
    genre: String,
    status: boolean
  }) {
    return this.http.post(BASE_URL, book);
  }

  getBooks(){
    return this.http.get(BASE_URL);
  }

  deleteBook(book: any){
    return this.http.delete(BASE_URL + "/" + book.id);
  }

  constructor(private http: HttpClient) { }
}
