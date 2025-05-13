# GuidePage

![Image](app/src/main/ic_launcher-web.png)

[![JitPack](https://img.shields.io/jitpack/v/github/jenly1314/GuidePage?logo=jitpack)](https://jitpack.io/#jenly1314/GuidePage)
[![Download](https://img.shields.io/badge/download-APK-brightgreen?logo=github)](https://raw.githubusercontent.com/jenly1314/GuidePage/master/app/release/app-release.apk)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen?logo=android)](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)
[![License](https://img.shields.io/github/license/jenly1314/GuidePage?logo=open-source-initiative)](https://opensource.org/licenses/mit)


GuidePage for Android 是一个App欢迎引导页。一般用于首次打开App时场景，通过引导页指南，概述App特色等相关信息

## 功能介绍
- [x] 链式调用，简单易用
- [x] 自定义配置，满足各种需求


## 效果展示
![Image](GIF.gif)

> 你也可以直接下载 [演示App](https://raw.githubusercontent.com/jenly1314/GuidePage/master/app/release/app-release.apk) 体验效果

## 引入

### Gradle:

1. 在Project的 **build.gradle** 或 **setting.gradle** 中添加远程仓库

    ```gradle
    repositories {
        //...
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
    ```
    
2. 在Module的 **build.gradle** 中添加依赖项

    ```gradle
    implementation 'com.github.jenly1314:GuidePage:1.0.0'
    ```

## 使用

### 代码示例

```Kotlin
    //简单调用示例
    GuidePage.load(intArrayOf(R.drawable.guide_page_1,R.drawable.guide_page_2,R.drawable.guide_page_3,R.drawable.guide_page_4))
            .pageDoneDrawableResource(R.drawable.btn_done)
            .start(this)//Activity or Fragment
```

```Kotlin
      //Demo中的调用示例
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

```

### 相关说明

> * 通过**GuidePage**链式调用，可以满足一些基本需求场景。

> * 当**GuidePage**中提供的配置无法满足需求时，可通过资源命名相同方式去自定义配置，即：资源覆盖方式。如**dimens**、**styles**等对应的资源。


更多使用详情，请查看[app](app)中的源码使用示例或直接查看 [API帮助文档](https://jitpack.io/com/github/jenly1314/GuidePage/latest/javadoc/)

## 相关推荐
- [SpinCounterView](https://github.com/jenly1314/SpinCounterView) 一个类似码表变化的旋转计数器动画控件。
- [CounterView](https://github.com/jenly1314/CounterView) 一个数字变化效果的计数器视图控件。
- [RadarView](https://github.com/jenly1314/RadarView) 一个雷达扫描动画后，然后展示得分效果的控件。
- [SuperTextView](https://github.com/jenly1314/SuperTextView) 一个在TextView的基础上扩展了几种动画效果的控件。
- [LoadingView](https://github.com/jenly1314/LoadingView) 一个圆弧加载过渡动画，圆弧个数，大小，弧度，渐变颜色，完全可配。
- [WaveView](https://github.com/jenly1314/WaveView) 一个水波纹动画控件视图，支持波纹数，波纹振幅，波纹颜色，波纹速度，波纹方向等属性完全可配。
- [GiftSurfaceView](https://github.com/jenly1314/GiftSurfaceView) 一个适用于直播间送礼物拼图案的动画控件。
- [FlutteringLayout](https://github.com/jenly1314/FlutteringLayout) 一个适用于直播间点赞桃心飘动效果的控件。
- [DragPolygonView](https://github.com/jenly1314/DragPolygonView) 一个支持可拖动多边形，支持通过拖拽多边形的角改变其形状的任意多边形控件。
- [CircleProgressView](https://github.com/jenly1314/CircleProgressView) 一个圆形的进度动画控件，动画效果纵享丝滑。
- [ArcSeekBar](https://github.com/jenly1314/ArcSeekBar) 一个弧形的拖动条进度控件，配置参数完全可定制化。
- [DrawBoard](https://github.com/jenly1314/DrawBoard) 一个自定义View实现的画板；方便对图片进行编辑和各种涂鸦相关操作。
- [compose-component](https://github.com/jenly1314/compose-component) 一个Jetpack Compose的组件库；主要提供了一些小组件，便于快速使用。

## 版本日志

#### v1.0.0：2019-12-24
*  GuidePage初始版本

---

![footer](https://jenly1314.github.io/page/footer.svg)

