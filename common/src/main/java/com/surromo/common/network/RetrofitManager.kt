package com.surromo.common.network

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.orhanobut.logger.Logger
import com.surromo.common.network.interceptor.MockInterceptor
import com.surromo.common.util.AppUtil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/15
 * desc  : TODO
 */
object RetrofitManager {

    private val cookieJar: PersistentCookieJar = PersistentCookieJar(
        SetCookieCache(), SharedPrefsCookiePersistor(AppUtil.getApplication())
    )

    private val mOkClient = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .followRedirects(false)
        .cookieJar(cookieJar)
        .addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Logger.d(message)
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY))
        .addInterceptor(MockInterceptor())
        .build()

    fun <T> getService(serviceClass: Class<T>, baseUrl: String = "https://www.wanandroid.com"): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(mOkClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(serviceClass)
    }

}