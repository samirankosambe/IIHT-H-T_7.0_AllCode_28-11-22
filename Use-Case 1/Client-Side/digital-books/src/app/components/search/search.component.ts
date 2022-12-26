import { Component, OnInit } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { Book } from 'src/app/entity/book';
import { User } from 'src/app/entity/user';
import { JwtClientService } from 'src/app/services/jwt-client.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  user: User=new User();
  book: Book;
  books: Book[]=[];
  category: string;
  title: string;
  author: string;
  price: number;
  publisher: string;
  // category: string='Comics';
  // title: string='Spiderman';
  // author: string='Peter David';
  // price: number=150;
  // publisher: string='Marvel Studios';
  queryParam: string='';
  isBookFound: boolean = false;
  isLoggedIn:boolean = false;     
  isSubscribed: boolean = false; 
  
  validate(searchForm:NgForm) {
    if(searchForm.valid){
      this.searchBook(searchForm);
    }else{
      alert("Please fill all the values");
    }
  }

  searchBook(searchForm:NgForm){
    this.queryParam ='category='+this.category+'&title='+this.title+'&author='+this.author+'&publisher='+this.publisher+'&price='+this.price;
    const promise = this.userService.searchBooks(this.queryParam);
    console.log(searchForm.value);
    
    promise.subscribe((response:any)=>{
      this.isBookFound =true;
      if(this.jwtService.getUserid() != null && this.jwtService.getToken() != null){
        this.isLoggedIn = true;
      } 
      //console.log(response);
      if(response.length > 0){
        this.books=response;
        this.isSubscribed = false; 

        searchForm.resetForm();
      }
    },function(error){
      console.log(error);
      alert("Something went wrong, please try again later");
    });
  }

  subscribeBook(bookid: number){
    if(this.jwtService.getUserid() != null){
      this.user.userID = parseInt(this.jwtService.getUserid());
      const promise = this.userService.subscribeBooks(this.user,bookid);
      promise.subscribe((response:any)=>{
        //console.log(response);
        if(response == 0){
          this.isSubscribed = true; 
        }
      },function(error){
        console.log(error);
        alert("Something went wrong, please try again later");
      });
    }else{
      alert("Please login as reader to subscribe a book");
    }
  }

  constructor(private userService: UserService,
    public jwtService: JwtClientService) {
      }


  ngOnInit(): void {
    
  }

}
