package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ComposeMsg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose_msg)

        val imageView = findViewById<ImageView>(R.id.backButton3)

        imageView.setOnClickListener {
            val intent = Intent(this, fragmentServices::class.java)
            onBackPressed()
        }
    }
}