import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtClientService {

  constructor() { }

  public setToken(token: string) {
    window.sessionStorage.setItem('token', token);
  }

  public getRole() {
    return window.sessionStorage.getItem('role');
  }

  public getToken() {
    return window.sessionStorage.getItem('token');
  }

  public setRole(role: string) {
    window.sessionStorage.setItem('role', role);
  }

  public setUserid(userid: string) {
    window.sessionStorage.setItem('userid', userid);
  }

  public getUserid() {
    return window.sessionStorage.getItem('userid');
  }

  public roleMatch(allowedRole: any): boolean {
    let isMatch = false;
    const userRole: string = this.getRole();
    if (userRole === allowedRole) {
      isMatch = true;
      return isMatch;
    } else {
      return isMatch;
    }
  }

  isLoggedIn(role){
    let token = this.getToken();
    if(token == undefined || token === '' || token == null || !this.roleMatch(role)){
      return false;
    }
    else{
      return true;
    }
  }

  logout(){
    window.sessionStorage.removeItem('token');
  }

}
