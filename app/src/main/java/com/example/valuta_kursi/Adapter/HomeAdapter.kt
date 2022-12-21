package com.example.valuta_kursi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.valuta_kursi.R


class HomeAdapter(val lists: List<DataModel>) : RecyclerView.Adapter<HomeAdapter.ItemHolder>() {
    inner class ItemHolder(mmm: View) : RecyclerView.ViewHolder(mmm)

    override fun getItemCount(): Int = lists.size
    var post = false

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = lists[position]
        holder.itemView.findViewById<TextView>(R.id.text2).text = itemData.Ccy
        holder.itemView.findViewById<TextView>(R.id.text3).text = itemData.Rate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.valuta_ly, parent, false)
        )
    }
}