package com.example.floristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Dapatkan referensi ke setiap list item
        val itemTanaman1: LinearLayout = findViewById(R.id.item_tanaman_1)
        val itemTanaman2: LinearLayout = findViewById(R.id.item_tanaman_2)
        val itemTanaman3: LinearLayout = findViewById(R.id.item_tanaman_3)

        // --- Listener untuk List Item ---

        // Fungsi navigasi yang akan digunakan berulang
        val navigateToOrder = {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        // --- Listener untuk List Item ---
        itemTanaman1.setOnClickListener {
            Toast.makeText(this, "Tanaman 1 dimasukkan ke keranjang!", Toast.LENGTH_SHORT).show()
            navigateToOrder() // Panggil fungsi navigasi
        }
        // ... lakukan hal yang sama untuk itemTanaman2 dan itemTanaman3 ...
        itemTanaman2.setOnClickListener {
            Toast.makeText(this, "Tanaman 2 dimasukkan ke keranjang!", Toast.LENGTH_SHORT).show()
            navigateToOrder()
        }
        itemTanaman3.setOnClickListener {
            Toast.makeText(this, "Tanaman Keren dimasukkan ke keranjang!", Toast.LENGTH_SHORT).show()
            navigateToOrder()
        }

        // --- Listener untuk Bottom Navigation Bar ---
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    true
                }
                R.id.nav_order -> {
                    // PINDAH KE ORDER ACTIVITY saat tombol Bottom Nav diklik
                    navigateToOrder()
                    true
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Anda mengklik Profile. Page Profile tidak dibuat!", Toast.LENGTH_LONG).show()
                    true
                }
                else -> false
            }
        }

        // Pastikan item Home terpilih saat pertama kali dibuka
        bottomNavigationView.selectedItemId = R.id.nav_home
    }
}