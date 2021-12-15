package com.surromo.common.base.application

import android.app.Application

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/15
 * desc  : 应用基类
 */
class BaseApplication : Application() {
    companion object {
        lateinit var instance: BaseApplication
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}