package com.surromo.common.base.bean

import androidx.lifecycle.MutableLiveData

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/15
 * desc  : 一个既包含请求返回结果又包含不同状态值的LiveData,用于将请求状态分发给UI
 */
class StateLiveData<T> : MutableLiveData<BaseResponse<T>>() { }