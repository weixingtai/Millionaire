package com.suromo.common.net

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : TODO
 */
sealed class MResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : MResult<T>()
    data class Error(val exception: Exception) : MResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}