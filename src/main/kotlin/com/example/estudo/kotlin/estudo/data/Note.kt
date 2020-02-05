package com.example.estudo.kotlin.estudo.data

import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "note")
@NamedQuery(
        name = "Note.findByTitle",
        query = "SELECT n FROM Note n WHERE n.title LIKE ?1"
)
data class Note (
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        var id: String = "",

        var title: String,

        var message: String,

        var location: String,

        @CreationTimestamp
        var created: Date = Date(),

        @UpdateTimestamp
        var modified: Date = Date()

    ) {
    constructor() : this("","","", "") {

    }

}


