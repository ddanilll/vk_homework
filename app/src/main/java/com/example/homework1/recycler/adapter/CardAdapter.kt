package com.example.homework1.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.R
import com.example.homework1.recycler.Item
import com.example.homework1.recycler.adapter.utils.ItemDiffUtil
import com.example.homework1.recycler.adapter.vh.CardViewHolder

class CardAdapter(): RecyclerView.Adapter<CardViewHolder>() {

    val items = ArrayList<Item>()

    fun setItems(items: List<Item>) {
        this.items.clear()
        this.items.addAll(items)
    }

    fun update(items: List<Item>) {
        val differ = ItemDiffUtil(this.items, items)
        val result = DiffUtil.calculateDiff(differ)
        setItems(items)
        result.dispatchUpdatesTo(this)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, null, false)
        )
    }

    override fun onBindViewHolder(
        holder: CardViewHolder,
        position: Int
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}