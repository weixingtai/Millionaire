package com.surromo.millionaire.net.service

import com.surromo.common.base.bean.BaseResponse
import com.surromo.millionaire.bean.home.BannerData
import retrofit2.http.GET

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/22
 * desc  : TODO
 */
interface HomeService {
    @GET("banner/json")
    suspend fun getBanner(): BaseResponse<List<BannerData>>
}