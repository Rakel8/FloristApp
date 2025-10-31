package com.example.floristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val kirimButton: Button = findViewById(R.id.btn_kirim)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        kirimButton.setOnClickListener {
            val intent = Intent(this, AddressFormActivity::class.java)
            startActivity(intent)
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    finish()
                    true
                }
                R.id.nav_order -> {
                    true
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Anda mengklik Profile. Page Profile tidak dibuat!", Toast.LENGTH_LONG).show()
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.selectedItemId = R.id.nav_order
    }
}