package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class officialReceivedForms : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_official_received_forms)

        val fullname = intent.getStringExtra("EXTRA_FULLNAME")
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = fullname
        }

        val age = intent.getStringExtra("EXTRA_AGE")
        val textView2 = findViewById<TextView>(R.id.textView2).apply {
            text = age
        }

        val selectStat = intent.getStringExtra("EXTRA_STATUS")
        val textView3 = findViewById<TextView>(R.id.textView3).apply {
            text = selectStat

        }

        val selectPurpose = intent.getStringExtra("EXTRA_PURPOSE")
        val textView4 = findViewById<TextView>(R.id.textView4).apply {
            text = selectPurpose

        }

        val imageView = findViewById<ImageView>(R.id.backButton)

        imageView.setOnClickListener {
            val intent = Intent(this, officialDashboard::class.java)
            onBackPressed()
        }

    }
}