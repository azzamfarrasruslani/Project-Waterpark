package com.example.waterpark_app.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.waterpark_app.R
import com.example.waterpark_app.databinding.ActivityMainBinding
import com.example.waterpark_app.ui.home.HomeActivity
import com.example.waterpark_app.ui.home.HomeFragment
import com.example.waterpark_app.ui.profile.ProfileActivity
import com.example.waterpark_app.ui.profile.ProfileFragment
import com.example.waterpark_app.ui.ticket.TicketFragment
import com.example.waterpark_app.ui.webview.WebActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Mengaktifkan tampilan edge-to-edge
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, 0)
            insets
        }

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            binding.bottomNavigationView.selectedItemId = R.id.menu_home
        }

        setupBottomNavListener()
    }

    private fun setupBottomNavListener() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.menu_home -> {
                    HomeFragment()
                }
                R.id.menu_ticket -> {
                    TicketFragment()
                }
                R.id.menu_profile -> {
                    ProfileFragment()
                }
                else -> {
                    HomeFragment()
                }
            }
            replaceFragment(fragment)
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }
}