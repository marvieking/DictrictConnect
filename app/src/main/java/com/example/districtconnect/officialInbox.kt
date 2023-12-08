package com.example.districtconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class officialInbox : AppCompatActivity() {



    //private lateinit var recyclerView: RecyclerView
    //private lateinit var adapter: MyAdapter
    //private val newsList: ArrayList<News> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_official_inbox)

        val imageView = findViewById<ImageView>(R.id.backButton)

        imageView.setOnClickListener {
            val intent = Intent(this, officialDashboard::class.java)
            onBackPressed()
        }

        //recyclerView = findViewById(R.id.recycler1)
        //adapter = MyAdapter(newsList)
        //recyclerView.adapter = adapter

        // Populate the newsList with your data
        //newsList.add(News(R.drawable.image_res, "Sender 1", "Subject 1", "Description 1"))
        //newsList.add(News(R.drawable.image_res, "Sender 2", "Subject 2", "Description 2"))
        // Add more news items as needed
    }
}