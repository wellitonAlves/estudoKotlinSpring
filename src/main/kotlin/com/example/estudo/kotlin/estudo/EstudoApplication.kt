package com.example.estudo.kotlin.estudo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EstudoApplication

fun main(args: Array<String>) {
	runApplication<EstudoApplication>(*args)
}
