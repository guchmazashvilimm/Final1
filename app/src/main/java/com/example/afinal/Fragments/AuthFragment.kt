package com.example.afinal.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.afinal.MainActivity
import com.example.afinal.R
import com.google.firebase.auth.FirebaseAuth

class AuthFragment : Fragment(R.layout.fragment_authorization) {
    private lateinit var emailText: EditText
    private lateinit var passwordText: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotButton: Button
    private lateinit var createAccount: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = Navigation.findNavController(view)

        emailText = view.findViewById(R.id.emailText)
        passwordText = view.findViewById(R.id.passwordText)
        loginButton = view.findViewById(R.id.loginButton)
        forgotButton = view.findViewById(R.id.forgotButton)
        createAccount = view.findViewById(R.id.createAccount)

        forgotButton.setOnClickListener(){
            val action = AuthFragmentDirections.actionAuthFragmentToForgotPasswordFragment()
            controller.navigate(action)

        }

        createAccount.setOnClickListener(){
            val action = AuthFragmentDirections.actionAuthFragmentToRegistrationFragment()
            controller.navigate(action)
        }
//        loginButton.setOnClickListener {
//            val action = AuthFragmentDirections.actionAuthFragmentToHospFragment()
//            controller.navigate(action)
//        }


        loginButton.setOnClickListener {


            val email = emailText.text.toString()
            val pass = passwordText.text.toString()

            if (email.isEmpty()) {
                emailText.error = "please Enter the E-mail"

            }
            if (!(email.contains("@"))) {
                emailText.error = "E-mail must contain @"

            }
            if (pass.isEmpty()) {
                passwordText.error = "Enter the password"

            }
            if (pass.length < 9) {
                passwordText.error = "password must contain more than 9 symbols "

            }
            if (!(pass.matches("(.*[A-Z].*)".toRegex())) ||
                !(pass.matches("(.*[0-9].*)".toRegex())) ||
                !(pass.matches("^(?=.*[_.()$&@]).*$".toRegex()))
            ) {
                passwordText.error = "password is not strong"

            }
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener { task ->
                if(task.isSuccessful){

                    val action = AuthFragmentDirections.actionAuthFragmentToHospFragment()
                    controller.navigate(action)
                }
                else {
                    Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
