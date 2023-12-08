package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class officialLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_official_login)

        val officialBtn = findViewById<Button>(R.id.toHomeOfficial)

        officialBtn.setOnClickListener {
            val officialBtnIntent = Intent(this, officialDashboard::class.java)
            startActivity(officialBtnIntent)
        }
    }
}