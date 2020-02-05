package com.example.estudo.kotlin.estudo.controller

import com.example.estudo.kotlin.estudo.data.Todo
import com.example.estudo.kotlin.estudo.data.TodoDTO
import com.example.estudo.kotlin.estudo.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/todos")
class TodoController {


    @Autowired
    private lateinit var service: TodoService


    @GetMapping("/obtain")
    fun getTodos(): Iterable<TodoDTO>{
        return service.getTodos()
    }

    @PutMapping("/inserir")
    fun inserirTodo(@RequestBody todo : TodoDTO) : TodoDTO {
       return service.inserirTodo(todo)
    }


    @DeleteMapping("/delete/{id}")
    fun delteTodo(@PathVariable(name = "id") id: String): Boolean{
       return service.delteTodo(id)
    }

    @PostMapping("/update")
    fun updateTodo(@RequestBody todo:TodoDTO) : TodoDTO {
        return service.updateTodo(todo)
    }
    @PostMapping("/later_than")
    fun getTodosLaterThan(@RequestBody payload: TodoLaterThanRequest):
            Iterable<TodoDTO> = service.getScheduledLaterThan(payload.date)


}