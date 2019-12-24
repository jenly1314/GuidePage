package com.king.guide.guidepage

import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
open class GuidePageActivity : AppCompatActivity(){

    lateinit var viewPager: ViewPager2

    /**
     * 欢迎引导页指示器
     */
    private var circleIndicator: CircleIndicator3? = null

    /**
     * 跳过控件，一般显示在欢迎引导页的右上角
     */
    private var tvSkip: View? = null

    private lateinit var mAdapter: GuidePageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = GuidePageSpec.orientation
        setTheme(GuidePageSpec.theme)
        setContentView(GuidePageSpec.pageLayoutId)
        init()
    }

    private fun init(){
        viewPager = findViewById(GuidePageSpec.viewPagerId)
        circleIndicator = findViewById(GuidePageSpec.indicatorId)
        tvSkip = findViewById(GuidePageSpec.skipId)

        tvSkip?.run {
            setOnClickListener{
                GuidePageSpec.onGuidePageChangeCallback?.onPageDone(true)
                if(GuidePageSpec.isAutoFinish) finish()
            }
            visibility = if(GuidePageSpec.showSkip) View.VISIBLE else View.GONE

            GuidePageSpec.skipBackgroundResource?.let {
                setBackgroundResource(it)
            }

            (this as? TextView)?.let {
                GuidePageSpec.skipTextAppearance.takeIf { GuidePageSpec.skipTextAppearance != R.style.GuidePage_SkipTextAppearance }?.apply {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        it.setTextAppearance(this)
                    }else{
                        it.setTextAppearance(this@GuidePageActivity,this)
                    }
                }

                GuidePageSpec.skipText?.takeIf { !TextUtils.isEmpty(GuidePageSpec.skipText) }?.apply {
                    it.text = this
                }
            }
        }


        mAdapter = GuidePageAdapter(GuidePageSpec.drawableData)
        viewPager.adapter = mAdapter

        GuidePageSpec.offscreenPageLimit?.let {
            viewPager.offscreenPageLimit = it
        }

        mAdapter.setOnItemChildClickListener(object : GuidePageAdapter.OnItemChildClickListener{
            override fun onClick(v: View, position: Int) {
                if(v.id == GuidePageSpec.pageDoneId){
                    GuidePageSpec.onGuidePageChangeCallback?.onPageDone(false)
                    if(GuidePageSpec.isAutoFinish) finish()
                }
            }
        })

        circleIndicator?.run {
            visibility = if(GuidePageSpec.showIndicator) View.VISIBLE else View.INVISIBLE
            GuidePageSpec.indicatorConfig?.let {
                initialize(it.toConfig())
            }
            createIndicators(mAdapter.itemCount,0)

            setViewPager(viewPager)
            mAdapter.registerAdapterDataObserver(adapterDataObserver)
        }


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                GuidePageSpec.onGuidePageChangeCallback?.onPageScrolled(position,positionOffset,positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if(position == mAdapter.itemCount - 1){
                    if(GuidePageSpec.lastPageHideSkip){
                        tvSkip?.visibility = View.GONE
                    }
                }else{
                    if(GuidePageSpec.showSkip){
                        tvSkip?.visibility = View.VISIBLE
                    }

                }
                GuidePageSpec.onGuidePageChangeCallback?.onPageSelected(position)
            }


            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                GuidePageSpec.onGuidePageChangeCallback?.onPageScrollStateChanged(state)
            }

        })

    }
}