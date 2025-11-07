package com.example.homework1.recycler.adapter.vh

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.DetailActivity
import com.example.homework1.R
import com.example.homework1.recycler.Item

class CardViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val card = view.findViewById<CardView>(R.id.card)
    private val number = view.findViewById<TextView>(R.id.number)

    fun bind(item: Item) {
        number.text = item.id.toString()
        card.setCardBackgroundColor(item.color)

        card.setOnClickListener {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("ITEM_ID", item.id)
            intent.putExtra("ITEM_COLOR", item.color)
            itemView.context.startActivity(intent)
        }
    }
}