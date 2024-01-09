package com.example.districtconnect

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ComposeMsg : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose_msg)

        val imageView = findViewById<ImageView>(R.id.backButton3)
        sharedPreferences = getSharedPreferences("Message", Context.MODE_PRIVATE)


        val submitbtn = findViewById<Button>(R.id.submitButton)

        imageView.setOnClickListener {
            val intent = Intent(this, fragmentServices::class.java)
            onBackPressed()
        }

        submitbtn.setOnClickListener {
            Toast.makeText(this, "Message Sent!", Toast.LENGTH_SHORT).show()
            callActivity()
        }

        val items = listOf("Complaint", "Concern", "Suggestion")
        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete)
        val adapter = ArrayAdapter(this, R.layout.subject, items)
        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->

                val subjectSelected = adapterView.getItemAtPosition(i)
                Toast.makeText(this, "Subject: $subjectSelected", Toast.LENGTH_SHORT).show()
            }
    }

    private fun callActivity() {

        val fromUser = findViewById<TextView>(R.id.fromUser)
        val subjectSelected = findViewById<AutoCompleteTextView>(R.id.auto_complete)
        val textMsg = findViewById<EditText>(R.id.textmsg)

        val displayUser = fromUser.text.toString()
        val displaySubject = subjectSelected.text.toString()
        val displayMsg = textMsg.text.toString()

        saveData("fromUser", displayUser)
        saveData("subjectSelected", displaySubject)
        saveData("textMsg", displayMsg)

        val intent = Intent(this, officialInbox::class.java)
        startActivity(intent)
    }

    private fun saveData(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
}