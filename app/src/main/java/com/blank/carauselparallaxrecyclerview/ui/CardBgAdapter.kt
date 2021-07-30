package com.blank.carauselparallaxrecyclerview.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blank.carauselparallaxrecyclerview.utils.ViewTypeItem
import com.blank.carauselparallaxrecyclerview.utils.getLayout

class CardBgAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ViewTypeItem.EMPTY.ordinal -> ViewTypeItem.EMPTY.getLayout(parent)
            else -> ViewTypeItem.HAVEDATA.getLayout(parent)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ViewTypeItem.EMPTY.ordinal
            else -> ViewTypeItem.HAVEDATA.ordinal
        }
    }

    override fun getItemCount(): Int = 10

    class ViewHolder(val v: View) : RecyclerView.ViewHolder(v)
}

class EmptyViewHolder(val v: View) : RecyclerView.ViewHolder(v)