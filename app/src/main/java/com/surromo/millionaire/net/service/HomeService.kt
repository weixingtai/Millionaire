package com.surromo.millionaire.net.service

import com.surromo.common.base.bean.BasePagingResponse
import com.surromo.common.base.bean.BaseResponse
import com.surromo.millionaire.bean.home.BannerData
import com.surromo.millionaire.bean.home.OrderDispatchBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/22
 * desc  : TODO
 */
interface HomeService {
    @GET("banner/json")
    suspend fun getBanner(): BaseResponse<List<BannerData>>

    /**
     * 获取首页派单内容
     */
    @GET("surromo/order/dispatch/{page}/json")
    suspend fun getDispatchOrder(
        @Path("page") page: Int
    ): BaseResponse<BasePagingResponse<ArrayList<OrderDispatchBean>>>
}