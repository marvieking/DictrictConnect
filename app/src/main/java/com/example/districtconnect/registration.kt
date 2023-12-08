package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val regbtn = findViewById<Button>(R.id.toHomeResident)
        regbtn.setOnClickListener {
            val residentLoginIntent = Intent(this, residentLogin::class.java)
            startActivity(residentLoginIntent)
        }
    }
}