package com.example.districtconnect

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

//        sendBtn.setOnClickListener {
//
//            var phoneNumber = phoneNoEditText.text.toString()
//            phoneNumber = "+63$phoneNumber"
//            val registrationIntent = Intent(this, Verification::class.java)
//            registrationIntent.putExtra("phoneNumber", phoneNumber)
//            startActivity(registrationIntent)
//
//        }



    }
}

// Imports
//
//class GenerateCode : AppCompatActivity() {
//
//    private lateinit var auth: FirebaseAuth
//    lateinit var verificationCode: String
//    lateinit var resendingToken: PhoneAuthProvider.ForceResendingToken
//    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_generate_code)
//
//        val sendBtn = findViewById<Button>(R.id.toGenerate)
//        val phoneNoEditText = findViewById<EditText>(R.id.inputNo)
//
//        sendBtn.setOnClickListener {
//
//            var phoneNumber = phoneNoEditText.text.toString()
//            phoneNumber = "+63$phoneNumber"
//            val registrationIntent = Intent(this, Verification::class.java)
//            registrationIntent.putExtra("phoneNumber", phoneNumber)
//            startActivity(registrationIntent)
//
//        }
//    }
//
//    private fun generateCode (mContext: Context, phoneNumber:String, isResent:Boolean ) {
//        val optionsBuilder = PhoneAuthOptions.newBuilder(auth)
//            .setPhoneNumber(phoneNumber) // Phone number to verify
//            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//            .setActivity(this) // Activity (for callback binding)
//
//        val options = if (isResent) {
//            // If it's a resend, set the resending token
//            optionsBuilder.setForceResendingToken(resendingToken).build()
//        } else {
//            optionsBuilder
//                .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                    override fun onVerificationCompleted(credential: PhoneAuthCredential) {
//                        signInWithPhoneAuthCredential(credential)
//                    }
//
//                    override fun onVerificationFailed(p0: FirebaseException) {
//                        Toast.makeText(mContext, "OTP verification failed!", Toast.LENGTH_SHORT).show()
//                    }
//
//                    override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
//                        super.onCodeSent(p0, p1)
//
//                        verificationCode = p0
//                        resendingToken = p1
//
//                        Toast.makeText(mContext, "OTP is successfully sent!", Toast.LENGTH_SHORT).show()
//                    }
//                }).build()
//        }
//
//        // Initial verification code request or resend
//        PhoneAuthProvider.verifyPhoneNumber(options)
//    }
//
//    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
//        val registrationIntent = Intent(this, registration::class.java)
//        startActivity(registrationIntent)
//    }
//}
//
//
