package com.example.floristapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
// Anda perlu menambahkan library Glide di build.gradle.kts jika belum
import com.bumptech.glide.Glide

class ListPlantAdapter(private val listPlant: ArrayList<Plant>) : RecyclerView.Adapter<ListPlantAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Kelas inner: Menampung referensi View dari item_row_plant.xml
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    // Dipanggil saat RecyclerView butuh ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        // Menginflate layout item_row_plant.xml
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_plant, parent, false)
        return ListViewHolder(view)
    }

    // Dipanggil untuk mengisi data ke View
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val plant = listPlant[position]

        // 1. Mengambil Resource ID (Integer) dari nama Drawable (String di strings.xml)
        val photoId = holder.itemView.context.resources.getIdentifier(
            plant.photoResourceName, "drawable", holder.itemView.context.packageName
        )

        // 2. Memuat Gambar menggunakan Glide
        // Catatan: Pastikan Anda sudah menambahkan dependency Glide!
        Glide.with(holder.itemView.context)
            .load(photoId)
            .into(holder.imgPhoto)

        // 3. Mengatur Teks
        holder.tvName.text = plant.name
        holder.tvDescription.text = plant.description

        // 4. Menambahkan Listener Klik
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listPlant[holder.adapterPosition])
        }
    }

    // Mengembalikan jumlah total item
    override fun getItemCount(): Int = listPlant.size

    // Interface untuk menangani klik dari luar Adapter
    interface OnItemClickCallback {
        fun onItemClicked(data: Plant)
    }
}