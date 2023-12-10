package com.exercise.tbchomeworksixteen.registerPage.model

data class UserRegister(
    val email: String,
    val password: String
)

data class TokenForRegister(
    val id: Int,
    val token: String
)