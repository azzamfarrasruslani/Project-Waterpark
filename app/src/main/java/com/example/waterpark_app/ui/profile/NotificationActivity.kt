package com.example.waterpark_app.ui.profile

import android.os.Bundle
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.waterpark_app.R
import com.example.waterpark_app.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding

    val notifications = listOf(
        mapOf(
            "title" to "Pembelian Tiket Berhasil",
            "message" to "Tiket Waterpark untuk 2 orang telah dikonfirmasi.",
            "time" to "Baru saja"
        ),
        mapOf(
            "title" to "Promo Weekend!",
            "message" to "Dapatkan diskon 20% untuk pembelian tiket keluarga.",
            "time" to "2 jam lalu"
        ),
        mapOf(
            "title" to "Notifikasi Pembayaran",
            "message" to "Pembayaran kamu telah diterima dengan sukses.",
            "time" to "Kemarin"
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val from = arrayOf("title", "message", "time")
        val to = intArrayOf(
            R.id.tvNotificationTitle,
            R.id.tvNotificationMessage,
            R.id.tvNotificationTime
        )

        val adapter = SimpleAdapter(
            this,
            notifications,
            R.layout.item_notification,
            from,
            to
        )

        binding.listViewNotifications.adapter = adapter

        binding.listViewNotifications.setOnItemClickListener { _, _, position, _ ->
            val item = notifications[position]
            val title = item["title"]
            val message = item["message"]
            Toast.makeText(
                this,
                "Notifikasi: $title\n$message",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
