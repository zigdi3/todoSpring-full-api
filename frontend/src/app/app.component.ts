import { Component, OnInit,} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Todo } from './todo';

import {TodoService} from "./todo.Service"
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
todos: Todo[] = []
form1: FormGroup = new FormGroup({
    description: new FormControl(' ', [Validators.required, Validators.minLength(4)]) 
    })
   
constructor( 

  private service:TodoService
){}


      ngOnInit(){
        this.listTodos();
}

      listTodos(){
      this.service.toList()
      .subscribe(todoList=> {
        console.log(todoList)
        this.todos = todoList
      })
      }

      submit(){
      const todo:Todo = {...this.form1.value}
      this.service
      .save( todo)
      .subscribe(savedtodo =>{
         this.todos.push(savedtodo)
         this.form1.reset()
      })
     }      

     delete(todo: Todo){
        this.service.delete(todo.id).subscribe({
        next: (response) => this.listTodos() 

        })
 }
        done(todo: Todo ){
          this.service.mmarkedDone(todo.id).subscribe({
          next: (updateTodo) => {
          todo.done = updateTodo.done
          todo.doneDate = updateTodo.doneDate
          }
        })          
}


}