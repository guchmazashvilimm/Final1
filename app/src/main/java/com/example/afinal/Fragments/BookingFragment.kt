package com.example.afinal.Fragments

import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.afinal.R
class BookingFragment: Fragment(R.layout.fragment_booking) {
    private lateinit var calendarView: CalendarView
    private lateinit var dateView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendarView = requireView().findViewById(R.id.calendarView)
        dateView = requireView().findViewById(R.id.dateView)

        calendarView.setOnDateChangeListener(CalendarView.OnDateChangeListener { _, year, month, dayOfMonth ->
            val date = dayOfMonth.toString() + "-" + (month + 1) + "-" + year
            dateView.text = date
        })
    }
}