package com.blank.carauselparallaxrecyclerview.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blank.carauselparallaxrecyclerview.R
import com.blank.carauselparallaxrecyclerview.ui.CardBgAdapter
import com.blank.carauselparallaxrecyclerview.ui.EmptyViewHolder

enum class ViewTypeItem {
    EMPTY, HAVEDATA
}

fun ViewTypeItem.getLayout(parent: ViewGroup): RecyclerView.ViewHolder {
    return when (this) {
        ViewTypeItem.HAVEDATA -> CardBgAdapter.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_view, parent, false)
        )
        else -> EmptyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_empty, parent, false)
        )
    }
}