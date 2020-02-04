package com.example.estudo.kotlin.estudo.service

import com.example.estudo.kotlin.estudo.data.Note
import com.example.estudo.kotlin.estudo.data.NoteDTO
import com.example.estudo.kotlin.estudo.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("Note service")
class NoteService {

    @Autowired
    lateinit var repository: NoteRepository

    fun getNotes(): Iterable<NoteDTO>{
      /*  return listOf(
                Note(
                        UUID.randomUUID().toString(),
                        "my first note",
                        "This is a message for the 1st note."
                ),
                Note(
                        UUID.randomUUID().toString(),
                        "my second note",
                        "This is a message for the 2st note."
                ))*/

        return repository.findAll().map { it -> NoteDTO(it) }
    }


    fun insertNote(note: NoteDTO): NoteDTO {
       // note.id = UUID.randomUUID().toString()
        repository.save(
                Note(
                        title = note.title,
                        message = note.message,
                        location = note.location
                )
        )
        return note
    }

    fun deleteNote(id: String): Boolean {
        repository.deleteById(id)
        return !repository.existsById(id)
    }

    fun updateNote(noteDto: NoteDTO) : NoteDTO{
        var note = repository.findById(noteDto.id).get()
        note.title = noteDto.title+ "[updated]"
        note.message = noteDto.message+ "[updated]"
        note.location = noteDto.location
        note = repository.save(note)
        return NoteDTO(note)
    }



}