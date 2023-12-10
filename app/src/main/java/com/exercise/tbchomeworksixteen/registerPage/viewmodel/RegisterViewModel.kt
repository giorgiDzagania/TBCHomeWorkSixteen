package com.exercise.tbchomeworksixteen.registerPage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercise.tbchomeworksixteen.registerPage.Api.ApiClientRegister
import com.exercise.tbchomeworksixteen.registerPage.model.TokenForRegister
import com.exercise.tbchomeworksixteen.registerPage.model.UserRegister
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class RegisterViewModel: ViewModel() {
    private val _tokenForRegister: MutableStateFlow<Response<TokenForRegister>?> = MutableStateFlow(null)
    val tokenForRegister = _tokenForRegister.asStateFlow()

    fun performRegister(userEmail: String, username:String ,userPassword:String){
        viewModelScope.launch {
            val response = ApiClientRegister.networkApiService.registerUser(UserRegister(userEmail,userPassword))
            _tokenForRegister.emit(response)
        }
    }

}