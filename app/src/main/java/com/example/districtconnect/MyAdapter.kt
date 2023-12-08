package com.example.districtconnect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val inboxCardview: ArrayList<News>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.inbox_cardview, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = inboxCardview[position]
        // Bind the data to the views in the item layout
        holder.img.setImageResource(currentItem.imageRes)
        holder.inboxSender.text = currentItem.sender
        holder.inboxSubject.text = currentItem.subject
        holder.desc.text = currentItem.description
    }

    override fun getItemCount(): Int {
        return inboxCardview.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ShapeableImageView = itemView.findViewById(R.id.imgResident)
        val inboxSender: TextView = itemView.findViewById(R.id.sender)
        val inboxSubject: TextView = itemView.findViewById(R.id.subject)
        val desc: TextView = itemView.findViewById(R.id.desc)
    }
}