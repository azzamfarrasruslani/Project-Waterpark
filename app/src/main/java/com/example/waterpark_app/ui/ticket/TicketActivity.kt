package com.example.waterpark_app.ui.ticket

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.waterpark_app.R
import com.example.waterpark_app.databinding.ActivityMainBinding
import com.example.waterpark_app.databinding.ActivityTicketBinding
import com.example.waterpark_app.ui.home.HomeActivity
import com.example.waterpark_app.ui.profile.ProfileActivity

class TicketActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTicketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("app_title", "AquaSplash")
                    intent.putExtra("app_subtitle", "Waterpark terbaik di Rumbai!")
                    startActivity(intent)
                    true
                }
                R.id.menu_ticket -> {
                    val intent = Intent(this, TicketActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}