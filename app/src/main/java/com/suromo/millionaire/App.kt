package com.suromo.millionaire

import android.app.Application
import android.content.Context
import com.suromo.millionaire.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.properties.Delegates

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : Application实现类
 */
class App : Application() {
    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()

        CONTEXT = applicationContext

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }

    }
}