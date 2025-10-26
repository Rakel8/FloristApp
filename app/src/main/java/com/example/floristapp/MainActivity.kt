package com.example.floristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Dapatkan referensi ke tombol dari layout
        val startButton: Button = findViewById(R.id.btn_start_now)

        // 2. Tambahkan listener saat tombol diklik
        startButton.setOnClickListener {
            // Ubah ini dari Toast menjadi navigasi (Intent) ke RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}