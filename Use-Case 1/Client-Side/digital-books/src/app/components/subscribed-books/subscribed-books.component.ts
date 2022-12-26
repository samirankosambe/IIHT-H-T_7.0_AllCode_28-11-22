import { Component, OnInit } from '@angular/core';
import { BookSubscription } from 'src/app/entity/book-subscription';
import { User } from 'src/app/entity/user';
import { JwtClientService } from 'src/app/services/jwt-client.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-subscribed-books',
  templateUrl: './subscribed-books.component.html',
  styleUrls: ['./subscribed-books.component.css']
})
export class SubscribedBooksComponent implements OnInit {

  user: User = new User();
  books:BookSubscription[];
  subscribId: number;
  subscribDt: Date;
  popupOpen: boolean = false;

  unSubscribe(userID,subscriptionId,index){
    const promise = this.userService.unSubscribeBook(userID,subscriptionId);
    promise.subscribe((response)=>{
     // console.log(response);
      if(response == 'Cancelled Subscription'){
          this.books.splice(index,1);
      }
    },(error)=>{
      console.log(error);
      
    })
  }

  viewContentofBook(subscriptionid:number){
    console.log(subscriptionid);
    
    const promise = this.userService.viewContent(this.jwtService.getUserid(), subscriptionid);
    promise.subscribe((response)=>{
    console.log(response);
      alert(response);
     },(error)=>{
       console.log(error);
       
     })
  }

  viewInvoice(subscriptionDt,subscriptionId){
    console.log(subscriptionDt+"   "+subscriptionId);
    this.subscribDt = subscriptionDt;
    this.subscribId = subscriptionId;
    this.popupOpen = true;
  }

  closePopup(){
    this.popupOpen = false;
  }

  constructor(private userService: UserService,
    public jwtService: JwtClientService) {
    this.user.userID = parseInt(this.jwtService.getUserid());
    const promise = this.userService.getListofSubscribedBooks(this.user);
    promise.subscribe((response: any) => {
      console.log(response);
      this.books = response;
    }, (error) => {
      console.log(error);

    });
  }

  ngOnInit(): void {
  }

}
