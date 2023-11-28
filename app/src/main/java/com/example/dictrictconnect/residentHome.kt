package com.example.dictrictconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.dictrictconnect.databinding.ActivityResidentHomeBinding

class residentHome : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityResidentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResidentHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(fragmentHome())

        binding.bottomNavView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(fragmentHome())
                R.id.services -> replaceFragment(fragmentServices())
                R.id.profile -> replaceFragment(fragmentAccount())

                else -> {

                }
            }

            true

        }
    }

    private fun replaceFragment(fragment: Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.frameHome, fragment).commit()
    }
}