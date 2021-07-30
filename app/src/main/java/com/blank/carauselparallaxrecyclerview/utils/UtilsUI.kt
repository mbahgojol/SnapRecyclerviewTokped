package com.blank.carauselparallaxrecyclerview.utils

import android.content.res.Resources
import android.util.TypedValue
import kotlin.math.roundToInt

/**
 * Created by ghozimahdi on 10/06/21.
 * Email : -
 * No Tpln : -
 * Profesi : Mobile Development Engineer Expert
 */

val Int.dp: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).roundToInt()

val Int.sp: Float
    get() = (this.dp / Resources.getSystem().displayMetrics.scaledDensity)