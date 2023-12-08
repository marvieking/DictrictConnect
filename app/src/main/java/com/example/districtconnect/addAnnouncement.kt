package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class addAnnouncement : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_announcement)

        val imageView = findViewById<ImageView>(R.id.backButton)

        imageView.setOnClickListener {
            val intent = Intent(this, officialDashboard::class.java)
            onBackPressed()
        }
    }
}