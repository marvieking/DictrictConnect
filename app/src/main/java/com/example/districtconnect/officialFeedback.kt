package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class officialFeedback : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_official_feedback)

        val imageView = findViewById<ImageView>(R.id.backButton)

        imageView.setOnClickListener {
            val intent = Intent(this, officialDashboard::class.java)
            onBackPressed()
        }
    }
}