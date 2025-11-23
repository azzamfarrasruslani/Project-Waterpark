package com.example.waterpark_app.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.waterpark_app.databinding.ActivityForgotPasswordBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Atur padding agar tidak tertutup status bar / navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSendLink.setOnClickListener {
            val email = binding.inputEmail.text.toString().trim()

            when {
                email.isEmpty() -> showError("Email tidak boleh kosong")
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> showError("Format email tidak valid")
                else -> {
                    hideError()
                    binding.progressBar.visibility = View.VISIBLE
                    binding.btnSendLink.isEnabled = false

                    lifecycleScope.launch {
                        delay(2000) // simulasi pengiriman link

                        binding.progressBar.visibility = View.GONE
                        binding.btnSendLink.isEnabled = true

                        val intent = Intent(this@ForgotPasswordActivity, CheckEmailActivity::class.java)
                        intent.putExtra("email", email)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }

    private fun showError(message: String) {
        binding.tvErrorMessage.text = message
        binding.tvErrorMessage.visibility = View.VISIBLE
    }

    private fun hideError() {
        binding.tvErrorMessage.visibility = View.GONE
    }
}
