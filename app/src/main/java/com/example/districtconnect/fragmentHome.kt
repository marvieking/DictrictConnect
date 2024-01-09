package com.example.districtconnect

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class fragmentHome : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        sharedPreferences = requireContext().getSharedPreferences("Announcement", Context.MODE_PRIVATE)


        val textView = view.findViewById<TextView>(R.id.residentTitle)
        val title = sharedPreferences.getString("title", "")
        textView.text = title

        val textView2 = view.findViewById<TextView>(R.id.residentContent)
        val content = sharedPreferences.getString("content", "")
        textView2.text = content

        return view
    }
}
