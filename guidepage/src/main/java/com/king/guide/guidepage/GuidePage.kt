package com.king.guide.guidepage

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import androidx.annotation.*
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2.ScrollState

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class GuidePage {

    private var mOptionsCompat: ActivityOptionsCompat? = null

    private constructor(drawableIds: IntArray?){
        GuidePageSpec.reset()
        GuidePageSpec.drawableData = drawableIds
    }

    companion object{

        /**
         * 加载欢迎引导页资源图片
         * @param drawableIds 引导页资源图片ID数组
         */
        fun load(drawableIds: IntArray?): GuidePage{
            return GuidePage(drawableIds)
        }

        /**
         * 加载欢迎引导页资源图片
         * @param drawableIds 引导页资源图片ID集合
         */
        fun load(drawableIds: List<Int>?): GuidePage{
            return GuidePage(drawableIds?.toIntArray())
        }
    }

    /**
     *  自定义引导页布局
     */
    fun pageLayoutId(@LayoutRes layoutId: Int): GuidePage{
        GuidePageSpec.pageLayoutId = layoutId
        return this
    }

    /**
     * ViewPager的ID
     * @param viewPagerId 默认{@code R.id.viewPager}
     */
    fun viewPagerId(@IdRes viewPagerId: Int): GuidePage{
        GuidePageSpec.viewPagerId = viewPagerId
        return this
    }

    /**
     * 指示器的ID
     * @param indicatorId 默认{@code R.id.circleIndicator}
     */
    fun indicatorId(@IdRes indicatorId: Int): GuidePage{
        GuidePageSpec.indicatorId = indicatorId
        return this
    }

    /**
     * dp转px
     */
    private fun dp2px(context: Context,dpValue: Float): Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.resources.displayMetrics).plus(0.5f).toInt()
    }

    /**
     * 得到IndicatorConfig
     */
    private fun obtainIndicatorConfig(): IndicatorConfig{
        return GuidePageSpec.indicatorConfig ?: IndicatorConfig()
    }

    /**
     * 指示器配置图片资源
     */
    fun indicatorDrawableResource(@DrawableRes drawableId: Int): GuidePage{
        GuidePageSpec.indicatorConfig = obtainIndicatorConfig().apply { this.drawableResId = drawableId }
        return this
    }

    /**
     * 指示器小圆点大小
     */
    fun indicatorSizeResource(context: Context,@DimenRes resId: Int): GuidePage{
        GuidePageSpec.indicatorConfig = obtainIndicatorConfig().apply {
            val size = context.resources.getDimensionPixelSize(resId)
            this.width = size
            this.height = size
        }
        return this
    }

    /**
     * 指示器小圆点大小
     * @param context
     * @param dpSize 小圆点大小，单位：dp
     */
    fun indicatorSize(context: Context,dpSize: Float): GuidePage{
        indicatorSize(dp2px(context,dpSize))
        return this
    }

    /**
     * 指示器小圆点大小
     * @param size 小圆点大小，单位：px
     */
    fun indicatorSize(size: Int): GuidePage{
        GuidePageSpec.indicatorConfig = obtainIndicatorConfig().apply {
            this.width = size
            this.height = size
        }
        return this
    }

    /**
     * 指示器的配置
     * @param indicatorConfig 指示器配置
     */
    fun indicatorConfig(indicatorConfig: IndicatorConfig?): GuidePage{
        GuidePageSpec.indicatorConfig = indicatorConfig
        return this
    }

    /**
     * 跳过视图控件的ID
     */
    fun skipId(@IdRes skipId: Int): GuidePage{
        GuidePageSpec.skipId = skipId
        return this
    }

    /**
     * 跳过视图控件的TextAppearance
     */
    fun skipTextAppearance(@StyleRes skipTextAppearance: Int): GuidePage{
        GuidePageSpec.skipTextAppearance = skipTextAppearance
        return this
    }

    /**
     * 自定义跳过视图控件文本内容
     */
    fun skipText(skipText: CharSequence): GuidePage{
        GuidePageSpec.skipText = skipText
        return this
    }

    /**
     * 自定义跳过视图控件背景
     */
    fun skipBackgroundResource(@DrawableRes drawableId: Int): GuidePage{
        GuidePageSpec.skipBackgroundResource = drawableId
        return this
    }

    /**
     * 是否显示右上角跳过视图控件
     * @param showSkip 默认为{@code false}
     */
    fun showSkip(showSkip: Boolean): GuidePage{
        GuidePageSpec.showSkip = showSkip
        return this
    }

    /**
     * 当欢迎引导页是最后一页时，设置是否隐藏右上角跳过视图控件
     * @param lastPageHideSkip 默认为{@code false}
     */
    fun lastPageHideSkip(lastPageHideSkip: Boolean): GuidePage{
        GuidePageSpec.lastPageHideSkip = lastPageHideSkip
        return this
    }

    /**
     * 自定义引导页Item布局
     */
    fun pageItemLayoutId(@IdRes layoutId: Int): GuidePage{
        GuidePageSpec.pageItemLayoutId = layoutId
        return this
    }

    /**
     * 自定义引导页Item加载图片控件的ID（即：Item中ImageView的ID）
     */
    fun pageImageViewId(@IdRes pageImageViewId: Int): GuidePage{
        GuidePageSpec.pageImageViewId = pageImageViewId
        return this
    }

    /**
     * 完成（立即体验）控件的ID
     */
    fun pageDoneId(@IdRes pageDoneId: Int): GuidePage{
        GuidePageSpec.pageDoneId = pageDoneId
        return this
    }

    /**
     * 设置完成（立即体验）的 Drawable
     */
    fun pageDoneDrawableResource(@DrawableRes drawableId: Int):GuidePage{
        GuidePageSpec.pageDoneDrawable = drawableId
        return this
    }

    /**
     * 引导页图片缩放类型{@link ImageView#ScaleType}
     * @param scaleType 默认为{@link ImageView#ScaleType#CENTER_CROP}
     */
    fun pageImageViewScaleType(scaleType: ImageView.ScaleType):GuidePage{
        GuidePageSpec.pageScaleType = scaleType
        return this
    }

    /**
     * 欢迎引导页改变回调接口
     * @param callback 当用户与欢迎引导页交互时，通过此回调接口通知
     */
    fun onGuidePageChangeCallback(callback: OnGuidePageChangeCallback?): GuidePage{
        GuidePageSpec.onGuidePageChangeCallback = callback
        return this
    }

    /**
     * 设置是否自动finish，当用户点击跳过或者完成(立即体验)操作时，如果autoFinish为true，贼会自动调用finish方法，关闭欢迎引导页
     * @param autoFinish 默认为{@code true}
     */
    fun autoFinish(autoFinish: Boolean): GuidePage{
        GuidePageSpec.isAutoFinish = autoFinish
        return this
    }

    /**
     * 引导页的主题风格
     * @param theme 默认：{@link R.style#GuidePageTheme}
     */
    fun theme(@StyleRes theme: Int): GuidePage{
        GuidePageSpec.theme = theme
        return this
    }

    /**
     * 引导页屏幕方向
     * @param orientation  默认：{@link ActivityInfo#SCREEN_ORIENTATION_PORTRAIT}
     */
    fun screenOrientation(orientation: Int): GuidePage{
        GuidePageSpec.orientation = orientation
        return this
    }

    /**
     * 引导页额外的视图控件ID，当目前所拥有的需求不满足时，为用户提供并管理额外的自定义视图控件
     */
    fun pageExtraViewIds(pageExtraViewIds: List<Int>?): GuidePage{
        GuidePageSpec.pageExtraViewIds = pageExtraViewIds?.toIntArray()
        return this
    }

    /**
     * 引导页额外的视图控件ID，当目前所拥有的需求不满足时，为用户提供并管理额外的自定义视图控件
     */
    fun pageExtraViewIds(pageExtraViewIds: IntArray?): GuidePage{
        GuidePageSpec.pageExtraViewIds = pageExtraViewIds
        return this
    }

    /**
     * 引导页额外的视图回调接口
     */
    fun onPageExtraViewCallback(callback: OnPageExtraViewCallback?): GuidePage{
        GuidePageSpec.onPageExtraViewCallback = callback
        return this
    }

    /**
     * 引导页 {@link ViewPager2#setOffscreenPageLimit(int)}方法
     */
    fun offscreenPageLimit(offscreenPageLimit: Int): GuidePage{
        GuidePageSpec.offscreenPageLimit = offscreenPageLimit
        return this
    }

    /**
     * 是否显示指示器
     * @param showIndicator 默认为{@code true}
     */
    fun showIndicator(showIndicator: Boolean): GuidePage{
        GuidePageSpec.showIndicator = showIndicator
        return this
    }

    /**
     * 设置界面跳转过渡动画
     */
    fun activityOptionsCompat(optionsCompat: ActivityOptionsCompat): GuidePage{
        this.mOptionsCompat = optionsCompat
        return this
    }

    /**
     * 得到ActivityOptionsCompat
     */
    private fun obtainActivityOptionsCompat(context: Context): ActivityOptionsCompat{
        return mOptionsCompat ?: ActivityOptionsCompat.makeCustomAnimation(context,R.anim.gp_anim_in,R.anim.gp_anim_out)
    }

    /**
     * 启动（前往）欢迎引导页
     */
    fun start(fragment: Fragment){
        val intent = Intent(fragment.context,GuidePageActivity::class.java)
        var bundle = fragment.context?.let { obtainActivityOptionsCompat(it) }?.toBundle()
        fragment.startActivity(intent,bundle)
    }

    /**
     * 启动（前往）欢迎引导页
     */
    fun start(activity: Activity){
        val intent = Intent(activity,GuidePageActivity::class.java)
        var bundle = obtainActivityOptionsCompat(activity).toBundle()
        activity.startActivity(intent,bundle)
    }


    interface OnGuidePageChangeCallback{
        /**
         * 当欢迎页滚动平移时，触发此回调方法
         */
        fun onPageScrolled(position: Int, positionOffset: Float, @Px positionOffsetPixels: Int){}
        /**
         * 当欢迎引导页完成滚动平移，选中某一页时，触发此回调方法
         * @param position 当前选中页
         */
        fun onPageSelected(position: Int){}
        /**
         * 当欢迎引导页的滚动状态改变时，触发此回调方法
         * @param state 当前滚动状态
         */
        fun onPageScrollStateChanged(@ScrollState state: Int){}
        /**
         * 当用户点击跳过或者完成（立即体验）时，触发此回调方法
         * @param skip 是否跳过。为{@code true}表示是通过跳过视图控件触发的此回调方法；为{@code false}表示是通过完成（立即体验）控件触发的此回调方法
         */
        fun onPageDone(skip: Boolean)
    }

    /**
     * 引导页提供额外视图回调接口，为用户提供并管理额外的自定义视图控件的回调
     */
    interface OnPageExtraViewCallback{
        /**
         * 当引导页存在额外视图时，触发此回调方法
         */
        fun onPageExtraView(v: View,position: Int,count: Int)
    }

}