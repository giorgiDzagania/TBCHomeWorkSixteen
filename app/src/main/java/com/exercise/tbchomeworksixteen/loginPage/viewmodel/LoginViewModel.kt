package com.exercise.tbchomeworksixteen.loginPage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercise.tbchomeworksixteen.loginPage.Api.ApiClient
import com.exercise.tbchomeworksixteen.loginPage.model.Token
import com.exercise.tbchomeworksixteen.loginPage.model.UserLogin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel: ViewModel() {
    private val _token: MutableStateFlow<Response<Token>?> = MutableStateFlow(null)
    val token = _token.asStateFlow()

    fun performLogIn(userEmail: String, userPassword:String){
        viewModelScope.launch {
            val response = ApiClient.networkApiService.logInUser(UserLogin(userEmail,userPassword))
            _token.emit(response)
        }
    }

}