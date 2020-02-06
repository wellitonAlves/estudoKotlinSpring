package com.example.estudo.kotlin.estudo.repository

import com.example.estudo.kotlin.estudo.security.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, String> {
    fun findOneByEmail(email:String): User?
}