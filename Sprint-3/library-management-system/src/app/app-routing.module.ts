import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './components/add-book/add-book.component';
import { BooksComponent } from './components/books/books.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [{path: "", component:HomeComponent}, {path:"add", component:AddBookComponent}
, {path: "books", component:BooksComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
