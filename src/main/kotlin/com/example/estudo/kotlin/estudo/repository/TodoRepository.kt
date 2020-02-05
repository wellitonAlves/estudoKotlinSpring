package com.example.estudo.kotlin.estudo.repository

import com.example.estudo.kotlin.estudo.data.Todo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : CrudRepository<Todo,String> {

    @Query("from Todo t where t.schedule > ?1")
    fun findScheduledLatherThan(date: Long): Iterable<Todo>

}