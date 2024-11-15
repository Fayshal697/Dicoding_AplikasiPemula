package com.example.speedstormapp

import android.content.Intent
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val listRacer: ArrayList<Racer>) : RecyclerView.Adapter<Adapter.ListViewHolder>() {

    // Menyediakan ViewHolder untuk RecyclerView
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_racer_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_racer_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_racer_description)
    }

    // Mengubah inflater untuk menggunakan layout item yang benar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_racer, parent, false)  // Ganti dengan layout item yang sesuai
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listRacer[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.EXTRA_NAME, listRacer[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    // Menentukan jumlah item dalam RecyclerView
    override fun getItemCount(): Int = listRacer.size
}
