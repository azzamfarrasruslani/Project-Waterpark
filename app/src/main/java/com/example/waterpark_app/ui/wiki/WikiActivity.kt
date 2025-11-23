package com.example.waterpark_app.ui.wiki

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.waterpark_app.R
import com.example.waterpark_app.databinding.ActivityWikiBinding
import com.google.android.material.tabs.TabLayoutMediator

class WikiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWikiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityWikiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 1. Inisialisasi Adapter
        val tabsAdapter = WikiTabsAdapter(this)

        // 2. Set adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout & ViewPager2 menggunakan Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // Atur judul untuk setiap tab
            when (position) {
                0 -> {
                    tab.text = "Pengenalan"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_info)
                }
                1 -> {
                    tab.text = "Format Model"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_file)
                }
                2 -> {
                    tab.text = "Konversi Model"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_sync)
                }
                3 -> {
                    tab.text = "Dataset & Implementasi"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_dataset)
                }
            }

        }.attach()
    }
}