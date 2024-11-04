package com.example.speedstormapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListRacerAdapter(private val listRacer: ArrayList<Racer>) : RecyclerView.Adapter<ListRacerAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_racer, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listRacer[position]
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listRacer[holder.adapterPosition])
            // Intent for detail activity
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("EXTRA_NAME", name)
            intent.putExtra("EXTRA_DESCRIPTION", description)
            intent.putExtra("EXTRA_PHOTO", photo)
            context.startActivity(intent)
        }

        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int = listRacer.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_descriptionn)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Racer)
    }
}