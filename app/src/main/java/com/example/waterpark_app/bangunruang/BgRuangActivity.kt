package com.example.waterpark_app.bangunruang

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.waterpark_app.R
import kotlin.math.PI
import kotlin.math.pow

class BgRuangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hitungbangunruang)

        // Mengatur padding sesuai sistem bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Persegi
        val sisiInput = findViewById<EditText>(R.id.sisi)
        val btnPersegi = findViewById<Button>(R.id.btn_hitung_persegi)
        val hasilPersegi = findViewById<TextView>(R.id.hasil_persegi)

        btnPersegi.setOnClickListener {
            val sisiText = sisiInput.text.toString()
            if (sisiText.isEmpty()) {
                Toast.makeText(this, "Masukkan sisi!", Toast.LENGTH_SHORT).show()
            } else {
                val sisi = sisiText.toDouble()
                val luasPersegi = sisi * sisi
                Log.i("Klik btnSubmit","Tombol berhasil di tekan. Isi dari inputNama = $luasPersegi")
                hasilPersegi.text = "Hasil: $luasPersegi"
            }
        }

        // Lingkaran
        val jariInput = findViewById<EditText>(R.id.jariJari)
        val btnLingkaran = findViewById<Button>(R.id.btn_hitung_lingkaran)
        val hasilLingkaran = findViewById<TextView>(R.id.hasil_lingkaran)

        btnLingkaran.setOnClickListener {
            val jariText = jariInput.text.toString()
            if (jariText.isEmpty()) {
                Toast.makeText(this, "Masukkan jari-jari!", Toast.LENGTH_SHORT).show()
            } else {
                val jari = jariText.toDouble()
                val luasLingkaran = PI * jari.pow(2)
                Log.i("Klik btnSubmit","Tombol berhasil di tekan. Isi dari inputNama = $luasLingkaran")
                hasilLingkaran.text = "Hasil: %.2f".format(luasLingkaran)
            }
        }

        val btnKeluar = findViewById<Button>(R.id.btnKeluar)
        btnKeluar.setOnClickListener {
            finish()
        }
    }
}
