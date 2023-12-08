package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class residentLogin : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resident_login)


        //val phone = findViewById<EditText>(R.id.inputPhone)
        //val password = findViewById<EditText>(R.id.inputPassword)
        val toResident = findViewById<Button>(R.id.toResident)
        val registerAct = findViewById<TextView>(R.id.registerActivity)

        registerAct.setOnClickListener {
            val GenerateCodeIntent = Intent(this, GenerateCode::class.java)
            startActivity(GenerateCodeIntent)
        }

        toResident.setOnClickListener {
                val intent = Intent(this, residentHome::class.java)
                startActivity(intent)
            }
        }


    }

