package com.example.waterpark_app.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.waterpark_app.R
import com.example.waterpark_app.databinding.ActivityHomeBinding
import com.example.waterpark_app.databinding.ActivityTicketBinding
import com.example.waterpark_app.ui.profile.ProfileActivity
import com.example.waterpark_app.ui.ticket.TicketActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val appTitle = intent.getStringExtra("app_title") ?: "Nama Aplikasi"
        val appSubtitle = intent.getStringExtra("app_subtitle") ?: "Deskripsi"


        binding.appName.text = appTitle
        binding.appSubtitle.text = appSubtitle


//        binding.bottomNavigationView.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.menu_home -> {
//                    val intent = Intent(this, HomeActivity::class.java)
//                    intent.putExtra("app_title", "AquaSplash")
//                    intent.putExtra("app_subtitle", "Waterpark terbaik di Rumbai!")
//                    startActivity(intent)
//                    true
//                }
//                R.id.menu_ticket -> {
//                    val intent = Intent(this, TicketActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
//                R.id.menu_profile -> {
//                    val intent = Intent(this, ProfileActivity::class.java)
//                    startActivity(intent)
//                    true
//                }
//                else -> false
//            }
//        }
    }
}
