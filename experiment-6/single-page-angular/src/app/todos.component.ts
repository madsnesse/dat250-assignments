import { Component, OnInit } from "@angular/core";
import { Todo } from "./todo";
import { TodoService } from "./todo-service";
import { FormBuilder } from '@angular/forms';

@Component({
    selector:    'todos',
    templateUrl: './todos.component.html',
    providers:  [ TodoService ]
})
export class Todos implements OnInit{

    todos:  Todo[] = [];

    newTodo = this.formBuilder.group({
        description: '',
        summary: ''
    });

    constructor(private service: TodoService,
        private formBuilder: FormBuilder,) { }

    ngOnInit() {
        this.updateTodos()
    }
    deleteTodo(id: number){
        console.log( "deleting: " + id)
        this.service.deleteTodo(id)
        this.updateTodos()
    }

    updateTodos(){
        this.todos = this.service.getAllTodos();
        console.log(this.todos)
    }

    addTodo(){
        console.log(this.newTodo.value)
        var summary = this.newTodo.value.summary
        var description = this.newTodo.value.description

        this.service.createTodo(summary!, description!)
        this.updateTodos()
    }

}