package com.example.waterpark_app.ui.ticket

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.waterpark_app.R
import com.example.waterpark_app.databinding.ActivityDetailTicketBinding

class DetailTicketActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Lihat e-ticket saya di aplikasi Waterpark!")
            }
            startActivity(Intent.createChooser(shareIntent, "Bagikan tiket melalui"))
        }
    }
}
