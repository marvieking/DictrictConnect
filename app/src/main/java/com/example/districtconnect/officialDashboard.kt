package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class officialDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_official_dashboard)

        val announce = findViewById<CardView>(R.id.announce)
        val sent = findViewById<CardView>(R.id.sentMsgs)
        val sentForms = findViewById<CardView>(R.id.sentForms)
        val sentAppointments = findViewById<CardView>(R.id.sentAppointments)
        val feedback = findViewById<CardView>(R.id.viewFeedback)

        sent.setOnClickListener {
            val sentIntent = Intent(this, officialInbox::class.java)
            startActivity(sentIntent)
        }

        sentForms.setOnClickListener {
            val sentFormsIntent = Intent(this, officialReceivedForms::class.java)
            startActivity(sentFormsIntent)
        }

        announce.setOnClickListener {
            val announcementIntent = Intent (this, addAnnouncement::class.java)
            startActivity(announcementIntent)
        }

        feedback.setOnClickListener {
            val feedbackIntent = Intent (this, officialFeedback::class.java)
            startActivity(feedbackIntent)
        }

        sentAppointments.setOnClickListener {
            val sentFormsIntent = Intent(this, officialAppointments::class.java)
            startActivity(sentFormsIntent)
        }

        val logoutButton: Button = findViewById<Button>(R.id.logoutButton)
        logoutButton.setOnClickListener {

            logout()
        }

        logoutButton.setOnClickListener {
            val logoutIntent = Intent(this, MainActivity::class.java)
            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(logoutIntent)
            finish()
        }
    }

    private fun logout() {
        val logoutIntent = Intent(this, MainActivity::class.java)
        logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(logoutIntent)
        finish()
    }
}