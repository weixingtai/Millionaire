package com.surromo.millionaire.net.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.surromo.common.base.bean.BasePagingResponse
import com.surromo.common.base.bean.StateLiveData
import com.surromo.common.base.repository.BaseRepository
import com.surromo.millionaire.bean.home.*
import com.surromo.millionaire.net.service.HomeService
import com.surromo.millionaire.paging.OrderDispatchPagingDataSource
import kotlinx.coroutines.flow.Flow
/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/22
 * desc  : TODO
 */
class HomeRepository(private val service: HomeService) : BaseRepository() {

    companion object {
        private const val PAGE_SIZE = 10
        val config = PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = 10,
            initialLoadSize = 10,
            enablePlaceholders = false,
//            maxSize = PAGE_SIZE * 5
        )
    }

    /**
     * 请求首页banner
     */
    suspend fun getBanner(bannerResponseLiveData: StateLiveData<MutableList<BannerResponse>>) {
        request({ service.getBanner() }, bannerResponseLiveData)
    }

//    suspend fun getDispatchOrder(
//        pageNo: Int,
//        stateLiveData: StateLiveData<BasePagingResponse<ArrayList<OrderDispatchResponse>>>,
//        isShowLoading : Boolean = false
//    ) {
//        request(
//            { service.getDispatchOrder(pageNo) },
//            stateLiveData,
//            isShowLoading
//        )
//    }
    fun getDispatchOrder(): Flow<PagingData<OrderDispatchResponse>> {
        return Pager(config) {
            OrderDispatchPagingDataSource(service)
        }.flow
    }
}