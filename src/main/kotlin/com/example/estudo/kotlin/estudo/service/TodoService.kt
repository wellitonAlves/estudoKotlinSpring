package com.example.estudo.kotlin.estudo.service

import com.example.estudo.kotlin.estudo.data.NoteDTO
import com.example.estudo.kotlin.estudo.data.Todo
import com.example.estudo.kotlin.estudo.data.TodoDTO
import com.example.estudo.kotlin.estudo.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service("Todo Service")
class TodoService {

    @Autowired
    lateinit var repository: TodoRepository

    fun getTodos(): Iterable<TodoDTO>{
      /*  return listOf(
                Todo(
                        UUID.randomUUID().toString(),
                        "my first note",
                        "This is a message for the 1st note.",
                        System.currentTimeMillis()
                ),
                Todo(
                        UUID.randomUUID().toString(),
                        "my second note",
                        "This is a message for the 2st note.",
                        System.currentTimeMillis()
                ))

       */

        return repository.findAll().map { it -> TodoDTO(it) }
    }


    fun inserirTodo(todo : TodoDTO) : TodoDTO {
        todo.id = UUID.randomUUID().toString()
        repository.save(
                Todo(
                        title = todo.title,
                        message = todo.message,
                        location = todo.location,
                        schedule = todo.schedule
                )
        )
        return todo
    }


    fun delteTodo(id: String): Boolean{
        repository.deleteById(id)
        return !repository.existsById(id)
    }

    fun updateTodo(todoDto: TodoDTO) : TodoDTO {
        var todo = repository.findById(todoDto.id).get()
        todo.title = todoDto.title + "[updated]"
        todo.message += todoDto.message+ "[updated]"
        todo.schedule = System.currentTimeMillis()
        todo =  repository.save(todo)
        return TodoDTO(todo)
    }
}