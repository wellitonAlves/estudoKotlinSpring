package com.example.estudo.kotlin.estudo.data

import java.util.*

class UserDetailsDTO(
        id: String = "",
        email: String = "",
        firstName: String = "",
        lastName: String = "",
        roles: String = "",
        enabled: Boolean = true,
        accountNonExpired: Boolean = true,
        accountNonLocked: Boolean =  true,
        credetialNonExpired: Boolean =  true,
        created: Date,
        modified: Date
) {
}