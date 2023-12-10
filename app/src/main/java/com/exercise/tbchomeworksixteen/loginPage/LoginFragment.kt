package com.exercise.tbchomeworksixteen.loginPage


import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.exercise.tbchomeworksixteen.BaseFragment
import com.exercise.tbchomeworksixteen.databinding.FragmentLoginBinding
import com.exercise.tbchomeworksixteen.loginPage.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

class LoginFragment: BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val logInViewModel: LoginViewModel by viewModels()

    override fun setUp() {
        binding.btnLogin.setOnClickListener {
            val email = binding.enterUsernameLogIn.text.toString()
            val password = binding.enterPassword.text.toString()
            checkLogIn(email, password)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            logInViewModel.token.collect{response->
                if (response != null){
                    if (response.isSuccessful){
                        Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }


    private fun checkLogIn(email:String, password:String){
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(context, "Please fill in the Information.", Toast.LENGTH_SHORT).show()
        }else{
            logInViewModel.performLogIn(email, password)
        }
    }

}