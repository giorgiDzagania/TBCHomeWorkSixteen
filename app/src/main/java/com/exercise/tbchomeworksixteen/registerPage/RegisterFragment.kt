package com.exercise.tbchomeworksixteen.registerPage


import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.exercise.tbchomeworksixteen.BaseFragment
import com.exercise.tbchomeworksixteen.databinding.FragmentRegisterBinding
import com.exercise.tbchomeworksixteen.registerPage.viewmodel.RegisterViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RegisterFragment: BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun setUp() {
        binding.btnRegister.setOnClickListener {
            val email = binding.enterEmail.text.toString()
            val userName = binding.enterUsername.text.toString()
            val password = binding.enterPassword.text.toString()
            checkRegister(email,userName,password)
        }


        viewLifecycleOwner.lifecycleScope.launch {
            registerViewModel.tokenForRegister.collect{response->
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


    private fun checkRegister(email: String,username:String ,password: String){
        if (email.isEmpty() || username.isEmpty() || password.isEmpty()){
            Toast.makeText(context, "Please fill in the Information.", Toast.LENGTH_SHORT).show()
        }else{
            registerViewModel.performRegister(email,username,password)
        }
    }
}