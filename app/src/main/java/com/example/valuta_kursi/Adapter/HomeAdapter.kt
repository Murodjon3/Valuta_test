package com.example.valuta_kursi.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.valuta_kursi.R
import com.example.valuta_kursi.repository.DocumentActivity


class HomeAdapter(val lists: List<DataModel>) : RecyclerView.Adapter<HomeAdapter.ItemHolder>() {

    inner class ItemHolder(mmm: View) : RecyclerView.ViewHolder(mmm)

    override fun getItemCount(): Int = lists.size
    var post = false

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = lists[position]
        val intent = holder.itemView.findViewById<FrameLayout>(R.id.Frame_ly)
        holder.itemView.findViewById<TextView>(R.id.text2).text = itemData.Ccy
        holder.itemView.findViewById<TextView>(R.id.text3).text = itemData.Rate
        holder.itemView.findViewById<CardView>(R.id.CardView_item_ly).setOnClickListener{

        }

    }
    private fun setExtraData(){
        val i = Intent(this, DocumentActivity::class.java)
        startActivity(i)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.valuta_ly, parent, false)
        )
    }

}