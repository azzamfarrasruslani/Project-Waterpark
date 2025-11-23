package com.example.waterpark_app.ui.welcome

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.waterpark_app.databinding.ActivityWelcomeScreenBinding
import androidx.viewpager2.widget.ViewPager2
import com.example.waterpark_app.ui.login.LoginActivity

class WelcomeScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Gunakan binding saja, jangan setContentView ganda
        binding = ActivityWelcomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Padding untuk sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fragmentsList = listOf(Welcome1Fragment(), Welcome2Fragment(), Welcome3Fragment())
        val adapter = WelcomeFragmentAdapter(this, fragmentsList)
        binding.welcomeViewPager.adapter = adapter

        // DotsIndicator
        binding.dotIndicator.attachTo(binding.welcomeViewPager)

        // Tombol Skip / Get Started
        binding.btnSkip.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Update teks tombol saat halaman terakhir
        binding.welcomeViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == fragmentsList.size - 1) {
                    binding.btnSkip.text = "Get Started"
                } else {
                    binding.btnSkip.text = "Skip"
                }
            }
        })
    }
}
