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

        rvPlant = findViewById(R.id.rv_plant)
        rvPlant.setHasFixedSize(true)

        listPlants.addAll(getListPlants())

        showRecyclerList()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

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

    private fun showRecyclerList() {
        rvPlant.layoutManager = LinearLayoutManager(this)
        val listPlantAdapter = ListPlantAdapter(listPlants)
        rvPlant.adapter = listPlantAdapter

        listPlantAdapter.setOnItemClickCallback(object : ListPlantAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Plant) {
                Toast.makeText(this@HomeActivity, "Memesan ${data.name}", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@HomeActivity, OrderActivity::class.java)
                startActivity(intent)
            }
        })
    }
}