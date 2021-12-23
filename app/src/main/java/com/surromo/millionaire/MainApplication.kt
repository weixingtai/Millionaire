package com.surromo.millionaire

import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import com.surromo.common.base.application.BaseApplication
import com.surromo.common.load.EmptyCallback
import com.surromo.common.load.ErrorCallback
import com.surromo.common.load.LoadingCallback
import com.surromo.millionaire.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/17
 * desc  : TODO
 */
class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        initLoadSir()
        initKoin()
    }

    private fun initLoadSir() {
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(ErrorCallback())//错误
            .addCallback(EmptyCallback())//空
            .setDefaultCallback(SuccessCallback::class.java)//设置默认加载状态页
            .commit()
    }

    private fun initKoin() {
        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule)
        }
    }

}