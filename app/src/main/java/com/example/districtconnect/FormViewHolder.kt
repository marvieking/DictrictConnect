package com.example.districtconnect

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FormViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val fullNameTextView: TextView = itemView.findViewById(R.id.senderFullname)
    private val ageTextView: TextView = itemView.findViewById(R.id.senderAge)
    private val statusTextView: TextView = itemView.findViewById(R.id.senderStatus)
    private val purposeTextView: TextView = itemView.findViewById(R.id.senderPurpose)

    fun bindItems(form: FormData) {
        fullNameTextView.text = form.fullName
        ageTextView.text = form.age
        statusTextView.text = form.status
        purposeTextView.text = form.purpose
    }
}

