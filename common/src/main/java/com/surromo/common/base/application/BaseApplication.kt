package com.surromo.common.base.application

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.surromo.common.BuildConfig

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/15
 * desc  : 应用基类
 */
open class BaseApplication : Application() {
    companion object {
        lateinit var instance: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initLogger()
    }

    /**
     * 初始化logger日志工具，自定义tag为MLog,debug版本打开日志，release版本关闭日志
     */
    private fun initLogger(){
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .tag("MLog")
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }
}