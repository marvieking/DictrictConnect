//package com.example.districtconnect
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//
//class officialReceivedForms : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_official_received_forms)
//
//        val fullname = intent.getStringExtra("EXTRA_FULLNAME")
//        val textView = findViewById<TextView>(R.id.senderFullname).apply {
//            text = fullname
//        }
//
//        val age = intent.getStringExtra("EXTRA_AGE")
//        val textView2 = findViewById<TextView>(R.id.senderAge).apply {
//            text = age
//        }
//
//        val selectStat = intent.getStringExtra("EXTRA_STATUS")
//        val textView3 = findViewById<TextView>(R.id.senderStatus).apply {
//            text = selectStat
//
//        }
//
//        val selectPurpose = intent.getStringExtra("EXTRA_PURPOSE")
//        val textView4 = findViewById<TextView>(R.id.senderPurpose).apply {
//            text = selectPurpose
//
//        }
//
//        val imageView = findViewById<ImageView>(R.id.backButton)
//
//        imageView.setOnClickListener {
//            val intent = Intent(this, officialDashboard::class.java)
//            onBackPressed()
//        }
//
//    }
//}

package com.example.districtconnect

import FormsAdapter
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.districtconnect.R.id.markReject

class officialReceivedForms : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_official_received_forms)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val textView = findViewById<TextView>(R.id.senderFullname)
        val fullname = sharedPreferences.getString("fullname", "")
        textView.text = fullname

        val textView2 = findViewById<TextView>(R.id.senderAge)
        val age = sharedPreferences.getString("age", "")
        textView2.text = age

        val textView3 = findViewById<TextView>(R.id.senderStatus)
        val selectStat = sharedPreferences.getString("status", "")
        textView3.text = selectStat

        val textView4 = findViewById<TextView>(R.id.senderPurpose)
        val selectPurpose = sharedPreferences.getString("purpose", "")
        textView4.text = selectPurpose


        val imageView = findViewById<ImageView>(R.id.backButton)
        imageView.setOnClickListener {
            onBackPressed()
        }

//        val markedFinishedButton = findViewById<Button>(R.id.markFinished)
//
//// Assuming formsList is a mutable list
//        val formsList = mutableListOf<FormData>()
//
//        markedFinishedButton.setOnClickListener {
//            // Get the entered data from the user (assuming you have EditText fields)
//            val fullNameEditText = this.findViewById<EditText>(R.id.senderFullname)
//            val ageEditText = this.findViewById<EditText>(R.id.senderAge)
//            val statusEditText = this.findViewById<EditText>(R.id.senderStatus)
//            val purposeEditText = this.findViewById<EditText>(R.id.senderPurpose)
//
//            val fullName = fullNameEditText.text.toString()
//            val age = ageEditText.text.toString()
//            val status = statusEditText.text.toString()
//            val purpose = purposeEditText.text.toString()
//
//            // Create a FormData object with the entered data and add it to the list
//            val formData = FormData(fullName, age, status, purpose)
//            formsList.add(formData)
//
//            // Show a Toast message with the entered data
//            val toastMessage = "Marked Finished\nFullName: $fullName\nAge: $age\nStatus: $status\nPurpose: $purpose"
//            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
//        }

        val markedFinishedButton = findViewById<Button>(R.id.markFinished)

        markedFinishedButton.setOnClickListener {
            // Show a Toast message when the button is clicked
            Toast.makeText(this, "Approved", Toast.LENGTH_SHORT).show()


            val recyclerView: RecyclerView = findViewById(R.id.multipleForms)

            val formsList = listOf(
                FormData(
                    sharedPreferences.getString("fullname", "") ?: "",
                    sharedPreferences.getString("age", "") ?: "",
                    sharedPreferences.getString("status", "") ?: "",
                    sharedPreferences.getString("purpose", "") ?: ""
                )
                // Add more data as needed
            )

            val formsAdapter = FormsAdapter(formsList)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = formsAdapter

            val markedRejectButton = findViewById<Button>(markReject)

            markedRejectButton.setOnClickListener {
                // Show a Toast message when the button is clicked
                Toast.makeText(this, "Rejected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
