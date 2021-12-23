package com.surromo.millionaire.ui.viewmodel.user

import androidx.lifecycle.viewModelScope
import com.surromo.common.base.bean.StateLiveData
import com.surromo.common.base.viewmodel.BaseViewModel
import com.surromo.millionaire.bean.home.BannerData
import com.surromo.millionaire.net.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/23
 * desc  : TODO
 */
class UserViewModel(val repo: HomeRepository) : BaseViewModel() {

    private val bannerLiveData = StateLiveData<List<BannerData>>()

    fun loadBanner() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getBanner(bannerLiveData)
        }
    }
}