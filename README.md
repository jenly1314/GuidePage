# GuidePage

![Image](app/src/main/ic_launcher-web.png)

[![Download](https://img.shields.io/badge/download-App-blue.svg)](https://raw.githubusercontent.com/jenly1314/GuidePage/master/app/release/app-release.apk)
[![JCenter](https://img.shields.io/badge/JCenter-1.0.0-46C018.svg)](https://bintray.com/beta/#/jenly/maven/guidepage)
[![JitPack](https://jitpack.io/v/jenly1314/GuidePage.svg)](https://jitpack.io/#jenly1314/GuidePage)
[![CI](https://travis-ci.org/jenly1314/GuidePage.svg?branch=master)](https://travis-ci.org/jenly1314/GuidePage)
[![CircleCI](https://circleci.com/gh/jenly1314/GuidePage.svg?style=svg)](https://circleci.com/gh/jenly1314/GuidePage)
[![API](https://img.shields.io/badge/API-16%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/mit-license.php)

GuidePage for Android 是一个App欢迎引导页。一般用于首次打开App时场景，通过引导页指南，概述App特色等相关信息

## 功能介绍
- [x] 链式调用，简单易用
- [x] 自定义配置，满足各种需求


## Gif 展示
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

2. 在Module的 **build.gradle** 里面添加引入依赖项

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

## 版本记录

#### v1.0.0：2019-12-24
*  GuidePage初始版本

## 赞赏
如果您喜欢GuidePage，或感觉GuidePage帮助到了您，可以点右上角“Star”支持一下，您的支持就是我的动力，谢谢 :smiley:
<p>您也可以扫描下面的二维码，请作者喝杯咖啡 :coffee:

<div>
   <img src="https://jenly1314.github.io/image/page/rewardcode.png">
</div>

## 关于我

| 我的博客                                                                                | GitHub                                                                                  | Gitee                                                                                  | CSDN                                                                                 | 博客园                                                                            |
|:------------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------|
| <a title="我的博客" href="https://jenly1314.github.io" target="_blank">Jenly's Blog</a> | <a title="GitHub开源项目" href="https://github.com/jenly1314" target="_blank">jenly1314</a> | <a title="Gitee开源项目" href="https://gitee.com/jenly1314" target="_blank">jenly1314</a>  | <a title="CSDN博客" href="http://blog.csdn.net/jenly121" target="_blank">jenly121</a>  | <a title="博客园" href="https://www.cnblogs.com/jenly" target="_blank">jenly</a>  |

## 联系我

| 微信公众号        | Gmail邮箱                                                                          | QQ邮箱                                                                              | QQ群                                                                                                                       | QQ群                                                                                                                       |
|:-------------|:---------------------------------------------------------------------------------|:----------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------|
| [Jenly666](http://weixin.qq.com/r/wzpWTuPEQL4-ract92-R) | <a title="给我发邮件" href="mailto:jenly1314@gmail.com" target="_blank">jenly1314</a> | <a title="给我发邮件" href="mailto:jenly1314@vip.qq.com" target="_blank">jenly1314</a> | <a title="点击加入QQ群" href="https://qm.qq.com/cgi-bin/qm/qr?k=6_RukjAhwjAdDHEk2G7nph-o8fBFFzZz" target="_blank">20867961</a> | <a title="点击加入QQ群" href="https://qm.qq.com/cgi-bin/qm/qr?k=Z9pobM8bzAW7tM_8xC31W8IcbIl0A-zT" target="_blank">64020761</a> |

<div>
   <img src="https://jenly1314.github.io/image/page/footer.png">
</div>
