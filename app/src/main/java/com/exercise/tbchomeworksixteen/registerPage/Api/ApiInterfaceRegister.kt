package com.exercise.tbchomeworksixteen.registerPage.Api

import com.exercise.tbchomeworksixteen.registerPage.model.TokenForRegister
import com.exercise.tbchomeworksixteen.registerPage.model.UserRegister
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterfaceRegister {

    @POST("register")
    suspend fun registerUser(@Body request: UserRegister): Response<TokenForRegister>

}