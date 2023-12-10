package com.exercise.tbchomeworksixteen.loginPage.Api

import com.exercise.tbchomeworksixteen.loginPage.model.Token
import com.exercise.tbchomeworksixteen.loginPage.model.UserLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("login")
    suspend fun logInUser(@Body request: UserLogin): Response<Token>

}