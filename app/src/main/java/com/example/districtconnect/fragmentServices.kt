package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class fragmentServices : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_services, container, false)

        val cardView: CardView = view.findViewById(R.id.composeMsg)
        cardView.setOnClickListener {
            val intent = Intent(activity, ComposeMsg::class.java)
            startActivity(intent)

        }

        val CardView2: CardView = view.findViewById(R.id.requestForm)
        CardView2.setOnClickListener {
            val anotherIntent = Intent(activity, RequestForm::class.java)
            startActivity(anotherIntent)
        }

        val CardView3: CardView = view.findViewById(R.id.makeAppointment)
        CardView3.setOnClickListener {
            val anotherIntent = Intent(activity, makeAppointment::class.java)
            startActivity(anotherIntent)
        }

        val CardView4: CardView = view.findViewById(R.id.giveFeedback)
        CardView4.setOnClickListener {
            val anotherIntent = Intent(activity, residentFeedback::class.java)
            startActivity(anotherIntent)
        }

        return view
    }
}