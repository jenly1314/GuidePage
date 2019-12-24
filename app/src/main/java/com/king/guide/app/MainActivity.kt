package com.king.guide.app

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.king.guide.guidepage.GuidePage

/**
 * GuidePage通过链式调用的方式
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onClick(v: View){
        //GuidePage链式调用
        GuidePage.load(intArrayOf(R.drawable.guide_page_1,R.drawable.guide_page_2,R.drawable.guide_page_3,R.drawable.guide_page_4))
            .pageDoneDrawableResource(R.drawable.btn_done)
//            .indicatorDrawableResource(R.drawable.indicator_radius)
//            .indicatorSize(this,6f)//默认5dp
            .showSkip(v.id == R.id.btn1)//是否显示“跳过”
            .lastPageHideSkip(true)//最后一页是否隐藏“跳过”
            .onGuidePageChangeCallback(object : GuidePage.OnGuidePageChangeCallback{//引导页改变回调接口

                override fun onPageDone(skip: Boolean) {
                    //TODO 当点击完成(立即体验)或者右上角的跳过时，触发此回调方法
                    //这里可以执行您的逻辑，比如跳转到APP首页或者登陆页
                    if(skip){
                        Toast.makeText(this@MainActivity,"跳过",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@MainActivity,"立即体验",Toast.LENGTH_SHORT).show()
                    }
                }

            })
            .start(this)//Activity or Fragment
    }


}
