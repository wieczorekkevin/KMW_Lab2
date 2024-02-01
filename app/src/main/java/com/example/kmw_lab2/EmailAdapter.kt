package com.example.kmw_lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>(){
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val senderText: TextView
        val titleText: TextView
        val summaryText: TextView
        val dogImage: ImageView

        init {
            senderText = itemView.findViewById(R.id.senderTv)
            titleText = itemView.findViewById(R.id.titleTv)
            summaryText = itemView.findViewById(R.id.summaryTv)
            dogImage = itemView.findViewById(R.id.dogView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails.get(position)
        // Set item views based on views and data model
        holder.senderText.text = email.sender
        holder.titleText.text = email.title
        holder.summaryText.text = email.summary
    }
}