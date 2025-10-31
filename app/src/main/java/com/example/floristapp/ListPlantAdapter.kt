package com.example.floristapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListPlantAdapter(private val listPlant: ArrayList<Plant>) : RecyclerView.Adapter<ListPlantAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_plant, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val plant = listPlant[position]

        val photoId = holder.itemView.context.resources.getIdentifier(
            plant.photoResourceName, "drawable", holder.itemView.context.packageName
        )

        Glide.with(holder.itemView.context)
            .load(photoId)
            .into(holder.imgPhoto)

        holder.tvName.text = plant.name
        holder.tvDescription.text = plant.description

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listPlant[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listPlant.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Plant)
    }
}