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

class RegistrationFragment: Fragment(R.layout.fragment_registration) {
    private lateinit var pass: EditText
    private lateinit var mail: EditText
    private lateinit var phone :EditText
    private lateinit var id : EditText
    private lateinit var city : EditText
    private lateinit var create : Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = Navigation.findNavController(view)

        pass = view.findViewById(R.id.pass)
        mail = view.findViewById(R.id.mail)
        phone = view.findViewById(R.id.phone)
        id = view.findViewById(R.id.id)
        city = view.findViewById(R.id.city)
        create = view.findViewById(R.id.create)

        create.setOnClickListener {
            val action =
                RegistrationFragmentDirections.actionRegistrationFragmentToAuthFragment()
            controller.navigate(action)

        }
        create.setOnClickListener{


            val email = mail.text.toString().trim()
            val password = pass.text.toString().trim()
            val phoneNum = phone.text.toString().trim()
            val idNum = id.text.toString().trim()
            val city = city.text.toString().trim()
            val create = create.text.toString().trim()

            if (email.isEmpty()){
                mail.error = "please enter your E-mail"
                return@setOnClickListener
            }
            if (!(email.contains("@"))){
                mail.error = "E-mail must contain @"
                return@setOnClickListener
            }
            if (password.isEmpty()){
                pass.error = "please enter the password"
                return@setOnClickListener
            }
            if (password.length < 9){
                pass.error = "password must contain more than 9 symbols"
                return@setOnClickListener
            }
            if (!(password.matches("(.*[A-Z].*)".toRegex()))||
                !(password.matches("(.*[0-9].*)".toRegex())) ||
                !(password.matches("^(?=.*[_.()$&@]).*$".toRegex()))){
                pass.error = "password is not so strong "
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(activity, "you signed up successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(activity, MainActivity::class.java))
                        activity?.finish()


                    }else {
                        Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show()
                    }
               }
        }
    }


}




