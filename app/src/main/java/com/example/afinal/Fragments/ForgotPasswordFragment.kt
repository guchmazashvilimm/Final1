package com.example.afinal.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.afinal.R
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordFragment : Fragment(R.layout.fragment_forgotpassword) {
    private lateinit var forgotEmail : EditText
    private lateinit var  rememberButton : Button
    private lateinit var createAccount : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forgotEmail = view.findViewById(R.id.forgotEmail)
        rememberButton = view.findViewById(R.id.rememberButton)
        createAccount = view.findViewById(R.id.createAccount)

        val controller = Navigation.findNavController(view)
        createAccount.setOnClickListener {
            val action = ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToAuthFragment()
        }

        rememberButton.setOnClickListener {
            val email = forgotEmail.text.toString()
            if (email.isEmpty()) {
                forgotEmail.error = "enter the E-mail"
                return@setOnClickListener
            }
            if (!(email.contains("@"))) {
                forgotEmail.error = "email must contain @"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(getActivity(), "password sent on email", Toast.LENGTH_SHORT)
                        .show()
                }else{
                    Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show()
                }


            }


        }

    }



}
