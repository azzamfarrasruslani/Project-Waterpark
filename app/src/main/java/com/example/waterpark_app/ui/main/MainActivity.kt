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

        // Menyesuaikan padding untuk system bars (status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Menampilkan fragment awal saat Activity pertama kali dibuat.
        //    Pengecekan savedInstanceState == null adalah best practice untuk menghindari
        //    penambahan fragment baru saat terjadi perubahan konfigurasi (misal: rotasi layar).
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            // Menandai item 'home' sebagai item yang aktif di BottomNavigationView
            binding.bottomNavigationView.selectedItemId = R.id.menu_home
        }

        // 2. Setup listener untuk BottomNavigationView
        setupBottomNavListener()
    }

    private fun setupBottomNavListener() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.menu_home -> {
                    HomeFragment()
                }
                R.id.menu_ticket -> {
                    TicketFragment() // Pastikan Anda sudah membuat TicketFragment
                }
                R.id.menu_profile -> {
                    ProfileFragment() // Pastikan Anda sudah membuat ProfileFragment
                }
                else -> {
                    // Default fragment jika terjadi kesalahan, sebaiknya kembali ke home
                    HomeFragment()
                }
            }
            replaceFragment(fragment)
            true // Return true untuk menandakan event telah ditangani
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }
}