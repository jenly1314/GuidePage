package com.king.guide.guidepage

import android.content.pm.ActivityInfo
import android.widget.ImageView
import androidx.annotation.StyleRes


/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
internal object GuidePageSpec {

    var pageLayoutId = R.layout.gp_guide_page_activity

    var viewPagerId = R.id.viewPager

    var indicatorId = R.id.circleIndicator

    var skipId: Int = R.id.tvSkip

    var skipTextAppearance = R.style.GuidePage_SkipTextAppearance

    var skipText: CharSequence? = null

    var skipBackgroundResource: Int? = null

    var showSkip = false

    var lastPageHideSkip = false

    var pageItemLayoutId = R.layout.gp_guide_page_item

    var drawableData: IntArray? = null

    var pageImageViewId = R.id.ivPage

    var pageDoneId = R.id.btnDone

    var pageDoneDrawable: Int? = null

    var pageScaleType = ImageView.ScaleType.CENTER_CROP

    var onGuidePageChangeCallback: GuidePage.OnGuidePageChangeCallback? = null

    var isAutoFinish = true

    @StyleRes
    var theme: Int = R.style.GuidePageTheme

    var orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    var indicatorConfig: IndicatorConfig? = null

    var pageExtraViewIds: IntArray? = null

    var onPageExtraViewCallback: GuidePage.OnPageExtraViewCallback? = null

    var offscreenPageLimit: Int? = null

    var showIndicator = true

    /**
     * 重置
     */
    fun reset(){
        pageLayoutId = R.layout.gp_guide_page_activity

        viewPagerId = R.id.viewPager

        indicatorId = R.id.circleIndicator

        skipId = R.id.tvSkip

        skipTextAppearance = R.style.GuidePage_SkipTextAppearance

        skipText = null

        skipBackgroundResource = null

        showSkip = false

        lastPageHideSkip = false

        drawableData = null

        pageItemLayoutId = R.layout.gp_guide_page_item

        pageImageViewId = R.id.ivPage

        pageDoneId = R.id.btnDone

        pageDoneDrawable = null

        pageScaleType = ImageView.ScaleType.CENTER_CROP

        onGuidePageChangeCallback = null

        isAutoFinish = true

        theme = R.style.GuidePageTheme

        orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        indicatorConfig = null

        pageExtraViewIds = null

        onPageExtraViewCallback = null

        offscreenPageLimit = null

        showIndicator = true

    }

}