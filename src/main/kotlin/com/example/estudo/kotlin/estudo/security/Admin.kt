package com.example.estudo.kotlin.estudo.security

import java.util.*
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity


@Entity
@DiscriminatorValue(value = "ADMIN")
class Admin(
            id: String = "",
            email: String = "",
            pwd: String = "",
            firstName: String = "",
            lastName: String = "",
            roles: String = "",
            enabled: Boolean = true,
            accountNonExpired: Boolean = true,
            accountNonLocked: Boolean =  true,
            credetialNonExpired: Boolean =  true,
            created: Date = Date(),
            modified: Date = Date()
    ): User(
            id,
            email,
            pwd,
            firstName,
            lastName,
            roles,
            enabled,
            accountNonExpired,
            accountNonLocked,
            credetialNonExpired,
            created,
            modified
    ) {
        constructor(): this("", "", "", "", "", "",
                true, true, true, true, Date(), Date())
    }
