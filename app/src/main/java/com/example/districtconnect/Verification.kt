package com.example.districtconnect

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider

class Verification : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var verificationCode: String
    lateinit var resendingToken: PhoneAuthProvider.ForceResendingToken

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

//        auth = Firebase.auth
//
//        val intent = intent
//        val phoneNumber = intent.getStringExtra("phoneNumber")
//
//        Toast.makeText(this, phoneNumber, Toast.LENGTH_SHORT).show()
//
//        var isResent: Boolean = false
//        val resendBtn = findViewById<TextView>(R.id.resendBtn)
//        resendBtn.setOnClickListener {
//            isResent = true
//            generateCode(this, phoneNumber.toString(), isResent)
//        }
//
//
//        val sendBtn = findViewById<Button>(R.id.toRegister)
//        sendBtn.setOnClickListener {
//            generateCode(this, phoneNumber.toString(), isResent)
//        }
//    }
//
//    private fun generateCode (mContext: Context, phoneNumber:String, isResent:Boolean ) {
//        val options = PhoneAuthOptions.newBuilder(auth)
//            .setPhoneNumber(phoneNumber) // Phone number to verify
//            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//            .setActivity(this) // Activity (for callback binding)
//            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
//                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
//                    signInWithPhoneAuthCredential(credential)
//
//                }
//
//
//
//                override fun onVerificationFailed(p0: FirebaseException) {
//                    Toast.makeText(mContext, "OTP verification failed!", Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
//                    super.onCodeSent(p0, p1)
//
//                    verificationCode = p0
//                    resendingToken = p1
//
//                    Toast.makeText(mContext, "OTP is successfully sent!", Toast.LENGTH_SHORT).show()
//                }
//            })
//        if(isResent){
//
//            PhoneAuthProvider.verifyPhoneNumber(options.setForceResendingToken(resendingToken).build())
//        }else{
//            PhoneAuthProvider.verifyPhoneNumber(options.build())
//        }
//    }
//
//    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
//        val registrationIntent = Intent(this, registration::class.java)
//        startActivity(registrationIntent)
    }
}
