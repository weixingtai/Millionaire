package com.surromo.millionaire.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.surromo.millionaire.bean.home.OrderDispatchResponse
import com.surromo.millionaire.net.service.HomeService

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/2/7
 * desc  : TODO
 */
class OrderDispatchPagingDataSource(var service: HomeService) :
PagingSource<Int,OrderDispatchResponse>(){
    override fun getRefreshKey(state: PagingState<Int, OrderDispatchResponse>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, OrderDispatchResponse> {
        return try {
            val pageNum = params.key ?: 1
            val data = service.getDispatchOrder(pageNum)
            val preKey = if (pageNum > 1) pageNum - 1 else null
            LoadResult.Page(data.data?.datas!!, prevKey = preKey, nextKey = pageNum + 1)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}