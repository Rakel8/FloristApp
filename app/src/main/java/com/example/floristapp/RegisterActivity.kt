package com.example.floristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Dapatkan referensi tombol
        val registerButton: Button = findViewById(R.id.btn_register)
        val loginButton: Button = findViewById(R.id.btn_login)

        // Listener untuk tombol Register
        registerButton.setOnClickListener {
            // Pindah ke RegisterFormActivity
            val intent = Intent(this, RegisterFormActivity::class.java)
            startActivity(intent)
        }

        // Listener untuk tombol Login
        loginButton.setOnClickListener {
            // Pindah ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}