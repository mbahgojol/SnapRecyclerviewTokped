package com.blank.carauselparallaxrecyclerview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blank.carauselparallaxrecyclerview.R
import com.blank.carauselparallaxrecyclerview.utils.ViewTypeItem

abstract class BlankSnapAdapter<T : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ViewTypeItem.EMPTY.ordinal -> EmptyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_empty, parent, false)
            )
            else -> initViewHolder(parent, viewType)
        }

    abstract fun initViewHolder(parent: ViewGroup, viewType: Int): T

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position > 0)
            ngeBindViewHolder(holder as T, position.minus(1))
    }

    abstract fun ngeBindViewHolder(holder: T, position: Int)

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ViewTypeItem.EMPTY.ordinal
            else -> ViewTypeItem.HAVEDATA.ordinal
        }
    }

    abstract fun itemCount(): Int
    override fun getItemCount(): Int = itemCount().plus(1)
    class EmptyViewHolder(v: View) : RecyclerView.ViewHolder(v)
}