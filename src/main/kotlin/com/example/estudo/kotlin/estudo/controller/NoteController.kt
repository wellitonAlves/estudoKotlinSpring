package com.example.estudo.kotlin.estudo.controller

import com.example.estudo.kotlin.estudo.data.Note
import com.example.estudo.kotlin.estudo.data.NoteDTO
import com.example.estudo.kotlin.estudo.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.awt.PageAttributes
import java.util.*


@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @Autowired
    private lateinit var service: NoteService

    @GetMapping(value = ["/obtain"], produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getNotes(): Iterable<NoteDTO> {
        return service.getNotes()
    }

    @PutMapping("/inserir")
    fun insertNote(@RequestBody note: NoteDTO): NoteDTO {
        return service.insertNote(note)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteNote(@PathVariable(name = "id") id: String): Boolean{
        return service.deleteNote(id)
    }

    @PostMapping("/update")
    fun updateNote(@RequestBody note:NoteDTO) : NoteDTO {
        return service.updateNote(note)
    }


}