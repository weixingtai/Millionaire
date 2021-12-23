package com.surromo.millionaire.di

import com.surromo.common.network.RetrofitManager
import com.surromo.millionaire.net.repository.HomeRepository
import com.surromo.millionaire.net.service.HomeService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/20
 * desc  : TODO
 */
val viewModelModule = module {


}

val serviceModule = module{
    single { RetrofitManager.getService(HomeService::class.java) }
}

val repositoryModule = module{
    single { HomeRepository(get()) }
}

val appModule = listOf(viewModelModule, serviceModule, repositoryModule)