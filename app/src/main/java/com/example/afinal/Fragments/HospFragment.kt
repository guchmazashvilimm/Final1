package com.example.afinal.Fragments

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.afinal.R

class HospFragment:Fragment(R.layout.fragment_hosp) {
    private lateinit var dname : EditText
    private lateinit var sym1 : EditText
    private lateinit var submit : Button
    private lateinit var textView: TextView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dname = view.findViewById(R.id.dname)
        sym1 = view.findViewById(R.id.sym1)
        submit = view.findViewById(R.id.submit)
        textView = view.findViewById(R.id.textView)


        val sharedPreferences = requireActivity().getSharedPreferences("pref", MODE_PRIVATE)
        val text = sharedPreferences.getString("successful", "n")

        textView.text = text
        submit.setOnClickListener(){
            var doctor = dname.text.toString()
            var symptoms = sym1.text.toString()
            var result = doctor + "\n" + symptoms
            textView.text.toString()
            sharedPreferences.edit().putString("successful", result).apply()
        }
    }

}
