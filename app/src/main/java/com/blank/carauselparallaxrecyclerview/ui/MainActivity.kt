package com.blank.carauselparallaxrecyclerview.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.blank.carauselparallaxrecyclerview.R
import com.blank.carauselparallaxrecyclerview.widget.BlankHorizontalScrollView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<BlankHorizontalScrollView>(R.id.rvItem)
        val img = findViewById<ImageView>(R.id.icFlash)
        val txt = findViewById<TextView>(R.id.txtFlashAuction)
        val showMore = findViewById<LinearLayout>(R.id.btnLihatSemua)

        rv.apply {
            adapter = CardBgAdapter()
            addViewTransforms(img)
            addViewTransforms(txt)
            addViewTransforms(showMore)
        }
    }
}