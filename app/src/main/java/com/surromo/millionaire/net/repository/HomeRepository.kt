package com.surromo.millionaire.net.repository

import com.surromo.common.base.bean.BasePagingResponse
import com.surromo.common.base.bean.StateLiveData
import com.surromo.common.base.repository.BaseRepository
import com.surromo.millionaire.bean.home.*
import com.surromo.millionaire.net.service.HomeService
import kotlin.coroutines.coroutineContext

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/22
 * desc  : TODO
 */
class HomeRepository(private val service: HomeService) : BaseRepository() {

    /**
     * 请求首页banner
     */
    suspend fun getBanner(bannerLiveData: StateLiveData<MutableList<Banner>>) {
        request({ service.getBanner() }, bannerLiveData)
    }

    suspend fun getDispatchOrder(
        pageNo: Int,
        stateLiveData: StateLiveData<BasePagingResponse<ArrayList<OrderDispatchBean>>>,
        isShowLoading : Boolean = false
    ) {
        request(
            { service.getDispatchOrder(pageNo) },
            stateLiveData,
            isShowLoading
        )
    }

}