package com.example.waterpark_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.waterpark_app.databinding.ActivitySplashScreenBinding
import com.example.waterpark_app.ui.login.LoginActivity
import com.example.waterpark_app.ui.main.MainActivity
import com.example.waterpark_app.ui.welcome.WelcomeScreenActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)
        val isFirstTime = sharedPref.getBoolean("isFirstTime", true)

        lifecycleScope.launch {
            delay(2000) // simulasi loading

            when {
                isLogin -> {
                    startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                }
                isFirstTime -> {
                    startActivity(Intent(this@SplashScreenActivity, WelcomeScreenActivity::class.java))
                    sharedPref.edit().putBoolean("isFirstTime", false).apply()
                }
                else -> {
                    startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
                }
            }
            finish()
        }
    }
}
