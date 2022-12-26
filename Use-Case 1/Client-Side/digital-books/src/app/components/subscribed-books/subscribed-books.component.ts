import { Component, OnInit } from '@angular/core';
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
  books:any[];
 

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

  viewContentofBook(content:string){
    window.open(content, 'blank');
  }

  constructor(private userService: UserService,
    public jwtService: JwtClientService) {
    this.user.userID = parseInt(this.jwtService.getUserid());
    const promise = this.userService.getListofSubscribedBooks(this.user);
    promise.subscribe((response: any) => {
      //console.log(response);
      response = JSON.parse(JSON.stringify(response));
      this.books = response.map(elem => JSON.parse(elem));
    }, (error) => {
      console.log(error);

    });
  }

  ngOnInit(): void {
  }


}
