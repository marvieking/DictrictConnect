package com.example.districtconnect

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class officialInbox : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    //private lateinit var recyclerView: RecyclerView
    //private lateinit var adapter: MyAdapter
    //private val newsList: ArrayList<News> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_official_inbox)

        sharedPreferences = getSharedPreferences("Message", Context.MODE_PRIVATE)

        val textView = findViewById<TextView>(R.id.sender)
        val fromUser = sharedPreferences.getString("fromUser", "")
        textView.text = fromUser

        val textView2 = findViewById<TextView>(R.id.subject)
        val subjectSelected = sharedPreferences.getString("subjectSelected", "")
        textView2.text = subjectSelected

        val textView3 = findViewById<TextView>(R.id.description)
        val textMsg = sharedPreferences.getString("textMsg", "")
        textView3.text = textMsg

        val imageView = findViewById<ImageView>(R.id.backButton)

        imageView.setOnClickListener {
            val intent = Intent(this, officialDashboard::class.java)
            onBackPressed()
        }
    }
}