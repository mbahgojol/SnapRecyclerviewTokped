package com.blank.carauselparallaxrecyclerview.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blank.carauselparallaxrecyclerview.R

class CardBgAdapter : BlankSnapAdapter<RecyclerView.ViewHolder>() {

    private val viewTypeLihatSemua = 100
    private val viewTypeData = 110

    override fun initViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            viewTypeLihatSemua -> LihatSemuaViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_lihatsemua, parent, false)
            )
            else -> ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_card_view, parent, false)
            )
        }
    }


    override fun ngeBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            Log.e("Posisi", position.toString())
        }
    }

    override fun multiViewType(position: Int): Int {
        return when (position) {
            itemCount().minus(1) -> viewTypeLihatSemua
            else -> viewTypeData
        }
    }

    override fun itemCount(): Int = 10

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v)
    class LihatSemuaViewHolder(v: View) : RecyclerView.ViewHolder(v)
}