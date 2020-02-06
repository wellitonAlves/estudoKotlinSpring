package com.example.estudo.kotlin.estudo.controller

import com.example.estudo.kotlin.estudo.data.TodoDTO
import com.example.estudo.kotlin.estudo.data.UserDTO
import com.example.estudo.kotlin.estudo.security.User
import com.example.estudo.kotlin.estudo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    lateinit var service: UserService


    @GetMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getUsers() = service.getUsers()

    @PutMapping("/admin",
                    produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
                    consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun inserirAdmin(@RequestBody user : UserDTO) {
        service.saveAdmin(user)
    }

    @PutMapping("/member",
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun inserirMember(@RequestBody user : UserDTO) {
        service.saveMember(user)
    }

    @DeleteMapping(value = ["/{id}"], produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun deleteUser(@PathVariable(name = "id") id: String) = service.deleteUser(id)

    @PostMapping(
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun updateUser(@RequestBody user: User): User? = service.updateUser(user)


}