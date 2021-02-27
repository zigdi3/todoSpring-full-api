import { Component,} from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {  FormsModule,  ReactiveFormsModule} from "@angular/forms";
import { Todo } from './todo';

import {TodoService} from "./todo.Service"
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent{
todos: Todo[] = []
fnotas: FormGroup = new FormGroup({
    description: new FormControl(' ') 
    })
    
constructor( 

  private service:TodoService
){}

    submit(){
      const todo:Todo = {...this.fnotas.value}
      this.service
      .save( todo)
      .subscribe(savedtodo =>{
         this.todos.push(savedtodo)
         this.fnotas.reset()
      })
     }      
    

        }

