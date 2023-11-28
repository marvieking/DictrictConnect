package com.example.dictrictconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class residentLogin : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resident_login)


        val phone = findViewById<EditText>(R.id.inputPhone)
        val password = findViewById<EditText>(R.id.inputPassword)
        val toResident = findViewById<Button>(R.id.toResident)



        toResident.setOnClickListener {
            if (phone.text.toString().equals("1234") &&
                password.text.toString().equals("admin")
            ) {
                val intent = Intent(this, residentHome::class.java)
                startActivity(intent)
            }
        }


    }
}
