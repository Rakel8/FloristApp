package com.example.floristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_form)

        // Dapatkan referensi elemen UI
        val fullNameEditText: EditText = findViewById(R.id.et_full_name)
        val usernameEditText: EditText = findViewById(R.id.et_reg_username)
        val passwordEditText: EditText = findViewById(R.id.et_reg_password)
        val registerButton: Button = findViewById(R.id.btn_register_form_submit)

        // Listener untuk tombol Register di formulir
        registerButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (fullName.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {

                Toast.makeText(this, "Pendaftaran Berhasil!", Toast.LENGTH_SHORT).show()

                // PINDAH KE HOME ACTIVITY
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Tutup RegisterFormActivity

            } else {
                Toast.makeText(this, "Semua Field Pendaftaran harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}