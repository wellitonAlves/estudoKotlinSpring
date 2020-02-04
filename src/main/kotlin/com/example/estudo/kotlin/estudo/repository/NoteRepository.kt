package com.example.estudo.kotlin.estudo.repository

import com.example.estudo.kotlin.estudo.data.Note
import org.springframework.stereotype.Repository
import org.springframework.data.repository.CrudRepository


@Repository
interface NoteRepository : CrudRepository<Note, String>