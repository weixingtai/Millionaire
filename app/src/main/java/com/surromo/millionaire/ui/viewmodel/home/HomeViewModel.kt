package com.surromo.millionaire.ui.viewmodel.home

import com.surromo.common.base.bean.StateLiveData
import com.surromo.common.base.viewmodel.BaseViewModel
import com.surromo.millionaire.bean.home.BannerResponse
import com.surromo.millionaire.net.repository.HomeRepository

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/23
 * desc  : TODO
 */
class HomeViewModel(private val repo: HomeRepository) : BaseViewModel() {
    val bannerLiveData = StateLiveData<MutableList<BannerResponse>>()
    fun loadBanner() {
//        viewModelScope.launch(Dispatchers.IO) {
//            repo.getBanner(bannerLiveData)
//        }

    }
}