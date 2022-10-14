import { Todo } from './todo'
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'


@Injectable()
export class TodoService {
  private todos: Todo[] = [];

  constructor(private http:HttpClient) {  }

  getAllTodos() {
    // this.getAllTodosFromBackend().subscribe(val => this.todos = val);
    this.todos = []
    this.getAllTodosFromBackend().subscribe(val => val.forEach( v => this.todos.push(new Todo(v.id, v.summary, v.description))))
    console.log(this.todos)
    return this.todos;
  }

  getAllTodosFromBackend(): Observable<[{ "id": number, "description": string, "summary": string }]>  {
    return this.http.get<any>('/todos').pipe(map(data => data));
  }

  deleteTodo(id: number){
    this.http.delete('/todos/'+ id).subscribe(res => console.log(res))
  }

  createTodo(summary: string, description: string){
    var body = {
        "id": Math.floor(Math.random()*100000000),
        "summary": summary,
        "description": description
    }
    this.http.post('/todos', body).subscribe(res => console.log(res))
}
}
