package com.surromo.common.base.bean

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/15
 * desc  : TODO
 */
class BaseResponse<T> {
    var data: T? = null
    var errorCode = -1
    var errorMsg: String? = ""
    var error: Throwable? = null
    var dataState: DataState? = null
}

