package com.exercise.tbchomeworksixteen.homepage

import androidx.navigation.fragment.findNavController
import com.exercise.tbchomeworksixteen.BaseFragment
import com.exercise.tbchomeworksixteen.R
import com.exercise.tbchomeworksixteen.databinding.FragmentHomePageBinding

class HomePageFragment : BaseFragment<FragmentHomePageBinding>(FragmentHomePageBinding::inflate) {

    override fun setUp() {
        registerPage()
        logInPage()
    }

    private fun logInPage() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_homePageFragment_to_loginFragment)
        }
    }

    private fun registerPage() {
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_homePageFragment_to_registerFragment)
        }
    }

}