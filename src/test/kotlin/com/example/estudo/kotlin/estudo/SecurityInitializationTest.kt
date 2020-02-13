package com.example.estudo.kotlin.estudo

import com.example.estudo.kotlin.estudo.data.UserDTO
import com.example.estudo.kotlin.estudo.security.Admin
import com.example.estudo.kotlin.estudo.security.Member
import com.example.estudo.kotlin.estudo.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.lang.RuntimeException


@SpringBootTest
class SecurityInitializationTest {

    @Autowired
    private lateinit var userService: UserService

    private val password = "12345"
    private val adminEmail = "admin@example.com"
    private val memberEmail = "member@example.com"

    @Test
    fun initAdmin() {
        try{
            val admin = userService.loadUserByUsername(adminEmail)
            if(admin is Admin){
                println("Admin user exists: ${admin.id}")
            }else {
                println("admin is not an admin")
            }

        }catch (e: RuntimeException){
            val toSave = UserDTO(
                    adminEmail,
                    password,
                    "admin",
                    "admin")
            val saved = userService.saveAdmin(toSave)
            println("Admin user inserted: ${saved.id}")
        }

    }


    @Test
    fun initMember() {
        try{
            val member = userService.loadUserByUsername(memberEmail)
            if(member is Member){
                println("Member user exists: ${member.id}")
            }else {
                println("member is not an member")
            }

        }catch (e: RuntimeException){
            val toSave = UserDTO(
                    memberEmail,
                    password,
                    "member",
                    "member")
            val saved = userService.saveAdmin(toSave)
            println("Member user inserted: ${saved.id}")
        }

    }


}