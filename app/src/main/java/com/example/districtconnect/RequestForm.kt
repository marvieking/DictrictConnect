package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RequestForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_form)

        val imageView = findViewById<ImageView>(R.id.backButton)
        val submitbtn = findViewById<Button>(R.id.submitButton)

        imageView.setOnClickListener {
            val intent = Intent(this, fragmentServices::class.java)
            onBackPressed()
        }

        submitbtn.setOnClickListener {
            Toast.makeText(this, "Request Submitted!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, fragmentServices::class.java)
            startActivity(intent)
        }

        submitbtn.setOnClickListener {
            callActivity()
        }
    }

    private fun callActivity() {
        val fullname = findViewById<EditText>(R.id.Fullname)
        val age = findViewById<EditText>(R.id.Age)
        val displayfullname = fullname.text.toString()
        val displayage = age.text.toString()

        val radioGroup = findViewById<RadioGroup>(R.id.selectStatus)
        val checkedStat = radioGroup.checkedRadioButtonId

        val radioGroupPurpose = findViewById<RadioGroup>(R.id.Purpose)
        val checkedPurpose = radioGroupPurpose.checkedRadioButtonId

        if (checkedStat == -1) {
            // No radio button selected
            Toast.makeText(this, "Please select your status", Toast.LENGTH_SHORT).show()
            return
        }

        val selectedRadioButton = findViewById<RadioButton>(checkedStat)
        val selectedStat = selectedRadioButton.text.toString()

        if (checkedPurpose == -1) {
            // No radio button selected for purpose
            Toast.makeText(this, "Please select your purpose", Toast.LENGTH_SHORT).show()
            return
        }

        val selectedRadioButtonPurpose = findViewById<RadioButton>(checkedPurpose)
        val selectedPurpose = selectedRadioButtonPurpose.text.toString()

        val intent = Intent(this, officialReceivedForms::class.java).apply {
            putExtra("EXTRA_FULLNAME", displayfullname)
            putExtra("EXTRA_AGE", displayage)
            putExtra("EXTRA_STATUS", selectedStat)
            putExtra("EXTRA_PURPOSE", selectedPurpose)
        }

        startActivity(intent)
    }
}

