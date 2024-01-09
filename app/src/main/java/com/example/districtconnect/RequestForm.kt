package com.example.districtconnect

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RequestForm : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_form)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val imageView = findViewById<ImageView>(R.id.backButton)
        val submitbtn = findViewById<Button>(R.id.submitButton)

        imageView.setOnClickListener {
            onBackPressed()
        }

        submitbtn.setOnClickListener {
            if (validateFields()) {
                Toast.makeText(this, "Request Successfully Submitted!", Toast.LENGTH_SHORT).show()
                callActivity()
            }
        }
    }

    private fun validateFields(): Boolean {
        val fullname = findViewById<EditText>(R.id.Fullname)
        val age = findViewById<EditText>(R.id.Age)

        val displayfullname = fullname.text.toString()
        val displayage = age.text.toString()

        if (displayfullname.isEmpty()) {
            Toast.makeText(this, "Kindly complete all required fields.", Toast.LENGTH_SHORT).show()
            return false
        }

        if (displayage.isEmpty()) {
            Toast.makeText(this, "Kindly complete all required fields.", Toast.LENGTH_SHORT).show()
            return false
        }

        val radioGroup = findViewById<RadioGroup>(R.id.Status)
        val checkedStat = radioGroup.checkedRadioButtonId

        if (checkedStat == -1) {
            // No radio button selected for status
            Toast.makeText(this, "Please select your Status", Toast.LENGTH_SHORT).show()
            return false
        }

        val radioGroupPurpose = findViewById<RadioGroup>(R.id.Purpose)
        val checkedPurpose = radioGroupPurpose.checkedRadioButtonId

        if (checkedPurpose == -1) {
            // No radio button selected for purpose
            Toast.makeText(this, "Please select your Purpose", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun callActivity() {
        val fullname = findViewById<EditText>(R.id.Fullname)
        val age = findViewById<EditText>(R.id.Age)
        val displayfullname = fullname.text.toString()
        val displayage = age.text.toString()

        val radioGroup = findViewById<RadioGroup>(R.id.Status)
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

        saveData("fullname", displayfullname)
        saveData("age", displayage)
        saveData("status", selectedStat)
        saveData("purpose", selectedPurpose)

        val intent = Intent(this, officialReceivedForms::class.java)
        startActivity(intent)
    }

    private fun saveData(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
}

//
//class RequestForm : AppCompatActivity() {
//
//    private lateinit var databaseReference: DatabaseReference
//    private lateinit var Fullname: EditText
//    private lateinit var Age: EditText
////    private var binding : ActivityRequestFormBinding? uncomment
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //setContentView(R.layout.activity_request_form)
//
//       binding = ActivityRequestFormBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        if (!FirebaseApp.getApps(this).isNotEmpty()) {
//            FirebaseApp.initializeApp(this)
//        }
//
//        val imageView = findViewById<ImageView>(R.id.backButton)
//        val submitbtn = binding.findViewById<Button>(R.id.submitButton)
//        Fullname = binding.findViewById(R.id.Fullname)
//        Age = binding.findViewById(R.id.Age)
//
//        imageView.setOnClickListener {
//            onBackPressed()
//        }

//        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
//
//        submitbtn.setOnClickListener {
//            Toast.makeText(this, "Request Submitted!", Toast.LENGTH_SHORT).show()
//            //callActivity()
//            saveResidentForm()
//        }
//    }
//
//    private fun saveResidentForm() {
//
//        val residentFullname = Fullname.text.toString()
//        val residentAge = Age.text.toString()
//
//        val radioGroup = findViewById<RadioGroup>(R.id.Status)
//        val checkedStat = radioGroup.checkedRadioButtonId
//
//        val radioGroupPurpose = findViewById<RadioGroup>(R.id.Purpose)
//        val checkedPurpose = radioGroupPurpose.checkedRadioButtonId
//
//        if (checkedStat == -1) {
//            // No radio button selected
//            Toast.makeText(this, "Please select your status", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        val selectedRadioButton = findViewById<RadioButton>(checkedStat)
//        val selectedStat = selectedRadioButton.text.toString()
//
//        if (checkedPurpose == -1) {
//            // No radio button selected for purpose
//            Toast.makeText(this, "Please select your purpose", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        val selectedRadioButtonPurpose = findViewById<RadioButton>(checkedPurpose)
//        val selectedPurpose = selectedRadioButtonPurpose.text.toString()
//
//        val residentID = databaseReference.push().key!!
//        val resident = ResidentData(residentID, residentFullname, residentAge, selectedStat, selectedPurpose)
//
//        // Save the resident object to the database
//        databaseReference.child(residentID).setValue(resident)
//            .addOnCompleteListener {
//                Toast.makeText(this, "Form Submitted!", Toast.LENGTH_SHORT).show()
//            } .addOnFailureListener {
//                Toast.makeText(this, "Failed to Submit!}", Toast.LENGTH_SHORT).show()
//            }
//    }
//}


//        binding.submitButton.setOnClickListener {
//            val residentFullname = Fullname.text.toString()
//            val resientAge = Age.text.toString()
//
//
//            val statusRadioButtonId = binding.Status.checkedRadioButtonId
//            val Status = if (statusRadioButtonId != -1) {
//                findViewById<RadioButton>(statusRadioButtonId).text.toString()
//            } else {
//                Toast.makeText(this, "Please select your status", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            val purposeRadioButtonId = binding.Purpose.checkedRadioButtonId
//            val Purpose = if (purposeRadioButtonId != -1) {
//                findViewById<RadioButton>(purposeRadioButtonId).text.toString()
//            } else {
//                Toast.makeText(this, "Please select your purpose", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            val user = User(Fullname, Age, Status, Purpose)
//
//            // Use push() to generate a unique key for each entry
//            val userKey = databaseReference.push().key
//
//            // Rest of your code...
//
//            userKey?.let {
//                databaseReference.child("Users").setValue(user).addOnSuccessListener {
//                    binding.Fullname.text.clear()
//                    binding.Age.text.clear()
//                    binding.Status.clearCheck()  // status is a RadioGroup
//                    binding.Purpose.clearCheck() // purpose is a RadioGroup
//
//                    Toast.makeText(this, "Successfully Submitted!", Toast.LENGTH_SHORT).show()
//
//                }.addOnFailureListener {
//                    Toast.makeText(this, "Failed to Submit", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
//}


//        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
//
//
//        binding.submitbtn.setOnClickListener {
//            Toast.makeText(this, "Request Submitted!", Toast.LENGTH_SHORT).show()
//            //callActivity()
//            saveResidentForm()
//        }
//
//        return binding.root
//    }
//
//    private fun saveResidentForm() {
//        val residentFullname = binding.Fullname.text.toString()
//        val residentAge = binding.Age.text.toString()
//
//        val checkedStat = binding.radioGroup.checkedRadioButtonId
//        val checkedPurpose = binding.radioGroupPurpose.checkedRadioButtonId
//
//        if (checkedStat == -1) {
//            // No radio button selected for status
//            Toast.makeText(this, "Please select your status", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        val selectedRadioButtonStat = binding.root.findViewById<RadioButton>(checkedStat)
//        val selectedStat = selectedRadioButtonStat.text.toString()
//
//        if (checkedPurpose == -1) {
//            // No radio button selected for purpose
//            Toast.makeText(this, "Please select your purpose", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        val selectedRadioButtonPurpose = binding.root.findViewById<RadioButton>(checkedPurpose)
//        val selectedPurpose = selectedRadioButtonPurpose.text.toString()
//
//        val residentID = databaseReference.push().key!!
//        val resident = ResidentData(residentID, residentFullname, residentAge, selectedStat, selectedPurpose)
//
//        // Save the resident object to the database
//        databaseReference.child(residentID).setValue(resident)
//            .addOnCompleteListener {
//                Toast.makeText(this, "Form Submitted!", Toast.LENGTH_SHORT).show()
//            }
//            .addOnFailureListener {
//                Toast.makeText(this, "Failed to Submit!", Toast.LENGTH_SHORT).show()
//            }
//
//    }
//
//
//}