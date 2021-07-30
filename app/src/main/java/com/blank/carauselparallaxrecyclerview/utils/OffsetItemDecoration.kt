package com.blank.carauselparallaxrecyclerview.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class OffsetItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        when {
            parent.getChildAdapterPosition(view) == 0 -> {
                setupOutRect(outRect, 8.dp, false)
            }
            parent.getChildAdapterPosition(view) == parent.adapter?.itemCount?.minus(1) -> {
                setupOutRect(outRect, 8.dp, true)
                setupOutRect(outRect, 8.dp, false)
            }
            else -> {
                setupOutRect(outRect, 8.dp, true)
            }
        }
        outRect.bottom = 16.dp
    }

    private fun setupOutRect(rect: Rect, offset: Int, start: Boolean) {
        if (start) {
            rect.left = offset
        } else {
            rect.right = offset
        }
    }
}