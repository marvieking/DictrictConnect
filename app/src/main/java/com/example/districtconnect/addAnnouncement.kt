package com.example.districtconnect

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class addAnnouncement : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_announcement)

        sharedPreferences = getSharedPreferences("Announcement", Context.MODE_PRIVATE)
        val imageView = findViewById<ImageView>(R.id.backButton)
        val addAnnounce = findViewById<Button>(R.id.addAnnounce)

        imageView.setOnClickListener {
            val intent = Intent(this, officialDashboard::class.java)
            onBackPressed()
        }

        addAnnounce.setOnClickListener {
            Toast.makeText(this, "Announcement Posted!", Toast.LENGTH_SHORT).show()
            callActivity()
        }
    }

    private fun callActivity() {
        val title = findViewById<EditText>(R.id.title)
        val content = findViewById<EditText>(R.id.content)

        val displayTitle = title.text.toString()
        val displayContent = content.text.toString()

        saveData("title", displayTitle)
        saveData("content", displayContent)

    }

    private fun saveData(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
}
