package com.suromo.millionaire.model.api

import com.suromo.common.net.MResponse
import com.suromo.millionaire.model.bean.User
import retrofit2.http.*

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : TODO
 */
interface MService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") passWord: String): MResponse<User>

}