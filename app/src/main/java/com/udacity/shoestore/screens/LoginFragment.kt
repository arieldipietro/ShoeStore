package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.User


class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    private lateinit var user : User
    private lateinit var shoeViewModel : ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )


        shoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        shoeViewModel.logOut()

        user = User("","")
        binding.user = user

        binding.loginButton.setOnClickListener {
            userValidation()
            }
        binding.registerButton.setOnClickListener {
            userValidation()
        }

        return binding.root
    }

fun userValidation() {
    if (user.email.isNotBlank() && user.password.isNotBlank()) {
        shoeViewModel.logInSucceed(user)
        findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    } else {
        if (user.email == "") {
            binding.username.setError("This field can not be blank")
        } else {
            binding.password.setError("This field can not be blank")
        }
    }
}




}