package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val residentBtn = findViewById<Button>(R.id.btnResident)
        residentBtn.setOnClickListener {
            val residentLoginIntent = Intent(this, residentLogin::class.java)
            startActivity(residentLoginIntent)
        }

        val officialBtn = findViewById<Button>(R.id.btnOfficial)
        officialBtn.setOnClickListener {
            val officialLoginIntent = Intent(this, officialLogin::class.java)
            startActivity(officialLoginIntent)
        }
    }
}