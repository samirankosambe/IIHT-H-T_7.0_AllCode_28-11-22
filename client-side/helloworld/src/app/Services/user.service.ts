import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import User from '../Entity/user';

const BASE_URL = 'http://localhost:5000/users';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  saveUser(user: {
    firstname: String,
    lastname: String,
    age: number,
    gender: String,
    email: String
  }) {
    return this.http.post(BASE_URL, user);
  }

  getUsers(){
    return this.http.get(BASE_URL);
  }

  deleteUsers(user: any){
    return this.http.delete(BASE_URL + "/" + user.id);
  }

  constructor(private http: HttpClient) { }
}
