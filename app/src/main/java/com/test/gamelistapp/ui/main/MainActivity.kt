package com.test.gamelistapp.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.test.gamelistapp.R
import com.test.gamelistapp.databinding.ActivityMainBinding
import com.test.gamelistapp.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            bottomNavigation.setOnItemSelectedListener { item ->
                when(item.itemId){
                    R.id.navigation_home -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
                        true
                    }
                    R.id.navigation_favorite -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
                        true
                    }
                    R.id.navigation_information -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
                        true
                    }
                    else -> false
                }
            }

            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()
            }
        }
    }
}