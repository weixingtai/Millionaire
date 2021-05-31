package com.suromo.millionaire.di

import org.koin.dsl.module

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : TODO
 */
val viewModelModule = module {
//    viewModel { NavigationViewModel(get()) }
}

val repositoryModule = module {
//    single { NavigationRepository() }
}

val appModule = listOf(viewModelModule, repositoryModule)