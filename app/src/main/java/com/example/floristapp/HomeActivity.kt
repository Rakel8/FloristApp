package com.example.floristapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    // 1. Deklarasi RecyclerView dan List Plant
    private lateinit var rvPlant: RecyclerView
    private val listPlants = ArrayList<Plant>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inisialisasi RecyclerView
        // Catatan: Pastikan ID di activity_home.xml sudah diubah menjadi rv_plant
        rvPlant = findViewById(R.id.rv_plant)
        rvPlant.setHasFixedSize(true)

        // Muat data dari strings.xml
        listPlants.addAll(getListPlants())

        // Tampilkan RecyclerView
        showRecyclerList()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Setup Bottom Nav Listener
        val navigateToOrder = {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    true
                }
                R.id.nav_order -> {
                    // Pindah ke Order Activity saat tombol Bottom Nav diklik
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
        bottomNavigationView.selectedItemId = R.id.nav_home
    }

    // --- FUNGSI HELPER UNTUK DATA DAN RECYCLERVIEW ---

    // Fungsi untuk mengambil data array dari resources
    private fun getListPlants(): ArrayList<Plant> {
        val dataName = resources.getStringArray(R.array.data_plant_name)
        val dataDescription = resources.getStringArray(R.array.data_plant_description)
        val dataPhotoName = resources.getStringArray(R.array.data_photo_drawable_name)

        val list = ArrayList<Plant>()
        for (i in dataName.indices) {
            val plant = Plant(dataName[i], dataDescription[i], dataPhotoName[i])
            list.add(plant)
        }
        return list
    }

    // Fungsi untuk mengatur RecyclerView, Adapter, dan Click Listener
    private fun showRecyclerList() {
        rvPlant.layoutManager = LinearLayoutManager(this)
        val listPlantAdapter = ListPlantAdapter(listPlants)
        rvPlant.adapter = listPlantAdapter

        // Implementasi OnItemClickCallback
        listPlantAdapter.setOnItemClickCallback(object : ListPlantAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Plant) {
                // Aksi saat item diklik: tampilkan Toast dan pindah ke OrderActivity
                Toast.makeText(this@HomeActivity, "Memesan ${data.name}", Toast.LENGTH_SHORT).show()

                // Navigasi ke Order Activity
                val intent = Intent(this@HomeActivity, OrderActivity::class.java)
                startActivity(intent)
            }
        })
    }
}