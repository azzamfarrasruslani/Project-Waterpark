package com.example.waterpark_app.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.waterpark_app.databinding.ActivityCheckEmailBinding

class CheckEmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCheckEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Atur padding agar tidak tertutup status bar / navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil email dari intent
        val email = intent.getStringExtra("email")

        // Set pesan
        binding.tvMessage.text = "Kami telah mengirimkan link reset password ke alamat email:\n\n$email\n\nSilakan cek inbox atau folder spam Anda."

        // Tombol kembali ke login
        binding.btnBackToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
