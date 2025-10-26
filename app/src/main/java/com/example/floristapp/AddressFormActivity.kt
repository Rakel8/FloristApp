package com.example.floristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddressFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_form)

        // Dapatkan referensi elemen UI
        val fullNameEditText: EditText = findViewById(R.id.et_full_name)
        val addressEditText: EditText = findViewById(R.id.et_address)
        val landmarkEditText: EditText = findViewById(R.id.et_landmark)
        val submitButton: Button = findViewById(R.id.btn_order_and_send)

        // Listener untuk tombol Order dan Kirim
        submitButton.setOnClickListener {
            // Ambil input
            val fullName = fullNameEditText.text.toString()
            val address = addressEditText.text.toString()
            val landmark = landmarkEditText.text.toString()

            // Cek apakah semua field tidak kosong
            if (fullName.isNotEmpty() && address.isNotEmpty() && landmark.isNotEmpty()) {

                Toast.makeText(this, "Order terkonfirmasi! Menuju Konfirmasi Page.", Toast.LENGTH_SHORT).show()

                // PINDAH KE CONFIRMATION ACTIVITY
                val intent = Intent(this, ConfirmationActivity::class.java)
                startActivity(intent)
                finish() // Menutup AddressFormActivity

            } else {
                Toast.makeText(this, "Semua Field Alamat harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}