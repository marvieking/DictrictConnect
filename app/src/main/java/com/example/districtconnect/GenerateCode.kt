package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class GenerateCode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_code)

        val sendBtn = findViewById<Button>(R.id.toGenerate)
        val phoneNoEditText = findViewById<EditText>(R.id.inputNo)

        sendBtn.setOnClickListener {

            var phoneNumber = phoneNoEditText.text.toString()
            phoneNumber = "+63$phoneNumber"
            val registrationIntent = Intent(this, Verification::class.java)
            registrationIntent.putExtra("phoneNumber", phoneNumber)
            startActivity(registrationIntent)

        }

    }
}