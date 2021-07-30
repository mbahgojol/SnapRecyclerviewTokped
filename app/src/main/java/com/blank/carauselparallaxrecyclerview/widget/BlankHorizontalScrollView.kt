package com.blank.carauselparallaxrecyclerview.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blank.carauselparallaxrecyclerview.utils.OffsetItemDecoration
import com.blank.carauselparallaxrecyclerview.utils.StartSnapHelper
import kotlin.math.abs

class BlankHorizontalScrollView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val targetViewToTransforms = arrayListOf<View>()
    private var margin = 8

    fun setMarginItem(margin: Int) {
        this.margin = margin
        addItemDecoration(OffsetItemDecoration(margin))
    }

    fun addViewTransforms(v: View) {
        targetViewToTransforms.add(v)
    }

    fun clearViewTransform() {
        targetViewToTransforms.clear()
    }

    private val linearLayoutManager by lazy {
        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private val scrollListener = object : OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (linearLayoutManager.findFirstVisibleItemPosition() == 0) {
                val firstVisibleItem: View? =
                    linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstVisibleItemPosition())
                val distanceFromLeft =
                    firstVisibleItem?.left?.toFloat()
                val translateX = distanceFromLeft?.toInt()?.times(0.2f)
                targetViewToTransforms.forEach { view ->
                    translateX?.let { view.translationX = it }
                }

                if (distanceFromLeft != null) {
                    if (distanceFromLeft <= 0) {
                        val itemSize = firstVisibleItem.width.toFloat()
                        val alpha =
                            abs(distanceFromLeft) / itemSize * 0.80f

                        targetViewToTransforms.forEach { view ->
                            view.alpha = 1 - alpha
                        }
                    }
                }
            }
        }
    }

    init {
        layoutManager = linearLayoutManager
        isNestedScrollingEnabled = false
        addItemDecoration(OffsetItemDecoration(margin))
        val snapHelper =
            StartSnapHelper()
        snapHelper.attachToRecyclerView(this)
        addOnScrollListener(scrollListener)
    }

    fun removeScrollListener() {
        removeOnScrollListener(scrollListener)
    }
}