package com.blank.carauselparallaxrecyclerview.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blank.carauselparallaxrecyclerview.R

class CardBgAdapter : BlankSnapAdapter<CardBgAdapter.ViewHolder>() {

    override fun initViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_view, parent, false)
        )

    override fun ngeBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            Log.e("Posisi", position.toString())
        }
    }

    override fun itemCount(): Int = 10

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v)
}