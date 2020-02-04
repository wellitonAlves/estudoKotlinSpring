package com.example.estudo.kotlin.estudo.repository

import com.example.estudo.kotlin.estudo.data.Todo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : CrudRepository<Todo,String>