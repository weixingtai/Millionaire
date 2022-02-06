package com.surromo.millionaire.net.service

import com.surromo.common.base.bean.BasePagingResponse
import com.surromo.common.base.bean.BaseResponse
import com.surromo.millionaire.bean.home.*
import retrofit2.http.*

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/22
 * desc  : TODO
 */
interface HomeService {
    @GET("home/banner/json")
    suspend fun getBanner(): BaseResponse<MutableList<Banner>>

    /**
     * 获取首页派单内容
     */
    @GET("home/order/dispatch/{page}/json")
    suspend fun getDispatchOrder(
        @Path("page") page: Int
    ): BaseResponse<BasePagingResponse<ArrayList<OrderDispatchBean>>>

}