import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtClientService } from './jwt-client.service';
import { Book } from 'src/app/entity/book';
import { User } from 'src/app/entity/user';

const USER_URL = 'http://localhost:5002';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });

  roleMatch(role: string) {
    return role === this.jwtService.getRole();
  }

  loginUser(loginData) {
    return this.http.post(USER_URL + "/sign-in", loginData, {
      headers: this.requestHeader
    });
  }

  signupUser(signupData) {
    return this.http.post(USER_URL + "/sign-up", signupData, {
      headers: this.requestHeader, responseType: "text"
    });
  }

  searchBooks(queryParam: string) {
    return this.http.get(USER_URL + "/search?" + queryParam);
  }

  //  To subscribe a book
  subscribeBooks(user: User, bookid: number) {
    return this.http.post(USER_URL + "/readers/" + bookid + "/subscribingBook", user);
  }

  getListofSubscribedBooks(user: User) {
    return this.http.get(USER_URL + "/readers/" + user.userid + "/books");
  }

  getSubscribedBook(user: User, subscriptionId: number) {
    return this.http.get(USER_URL + "/readers/" + user.userid + "/books" + subscriptionId);
  }

  viewContent(userId: number, subscriptionId: number) {
    return this.http.get(USER_URL + "/readers/" + userId + "/books/" + subscriptionId + "/read", { responseType: "text" });
  }

  unSubscribeBook(userID: number, subscriptionId: number) {
    return this.http.post(USER_URL + "/readers/" + userID + "/books/" + subscriptionId + "/cancel-subscription", '', { responseType: "text" });
  }

  addBook(userId: number, book: Book) {
    return this.http.post(USER_URL + "/author/" + userId + "/books", book, { responseType: "text" })
  }

  getAllAuthorBooks(authorId: number) {
    return this.http.get(USER_URL + "/author/" + authorId + "/getbooks");
  }

  editBook(authorId: number, bookId: number, book: Book) {
    return this.http.put(USER_URL + "/author/" + authorId + "/books/" + bookId, book);
  }

  getBookByID(bookId: number) {
    return this.http.get(USER_URL + "/author/" + bookId + "/getbook");
  }

  changeStatusOfBook(authorId: number, bookId: number) {
    return this.http.post(USER_URL + "/author/" + authorId + "/books/" + bookId + "/changeStatus", '', { responseType: "text" })
  }

  constructor(private http: HttpClient, private jwtService: JwtClientService) { }
}
