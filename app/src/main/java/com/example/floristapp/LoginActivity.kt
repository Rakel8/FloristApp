package com.example.floristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Dapatkan referensi elemen UI
        val usernameEditText: EditText = findViewById(R.id.et_username)
        val passwordEditText: EditText = findViewById(R.id.et_password)
        val loginButton: Button = findViewById(R.id.btn_login_form)

        // Listener untuk tombol Login di formulir
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {

                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

                // PINDAH KE HOME ACTIVITY
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Tutup LoginActivity agar user tidak bisa kembali dengan tombol back

            } else {
                Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}