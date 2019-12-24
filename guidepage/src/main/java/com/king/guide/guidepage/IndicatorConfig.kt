package com.king.guide.guidepage

import android.view.Gravity
import android.widget.LinearLayout
import androidx.annotation.AnimatorRes
import androidx.annotation.DrawableRes
import me.relex.circleindicator.Config

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class IndicatorConfig {

    var width = -1
    var height = -1
    var margin = -1
    @AnimatorRes
    var animatorResId = R.animator.scale_with_alpha
    @AnimatorRes
    var animatorReverseResId = 0
    @DrawableRes
    var drawableResId = R.drawable.gp_indicator_drawable
    @DrawableRes
    var drawableUnselectedId = 0
    var orientation = LinearLayout.HORIZONTAL
    var gravity = Gravity.CENTER




    internal fun toConfig(): Config{
        return Config.Builder()
            .width(width)
            .height(height)
            .margin(margin)
            .animator(animatorResId)
            .animatorReverse(animatorReverseResId)
            .drawable(drawableResId)
            .drawableUnselected(drawableUnselectedId)
            .orientation(orientation)
            .gravity(gravity)
            .build()
    }
}