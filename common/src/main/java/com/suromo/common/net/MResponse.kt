package com.suromo.common.net

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import java.io.IOException

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : TODO
 */
data class MResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)

suspend fun <T : Any> MResponse<T>.executeResponse(successBlock: (suspend CoroutineScope.() -> Unit)? = null,
                                                     errorBlock: (suspend CoroutineScope.() -> Unit)? = null): MResult<T> {
    return coroutineScope {
        if (errorCode == -1) {
            errorBlock?.let { it() }
            MResult.Error(IOException(errorMsg))
        } else {
            successBlock?.let { it() }
            MResult.Success(data)
        }
    }
}

suspend fun <T : Any> MResponse<T>.doSuccess(successBlock: (suspend CoroutineScope.(T) -> Unit)? = null): MResponse<T> {
    return coroutineScope {
        if (errorCode != -1) successBlock?.invoke(this, this@doSuccess.data)
        this@doSuccess
    }

}

suspend fun <T : Any> MResponse<T>.doError(errorBlock: (suspend CoroutineScope.(String) -> Unit)? = null): MResponse<T> {
    return coroutineScope {
        if (errorCode == -1) errorBlock?.invoke(this, this@doError.errorMsg)
        this@doError
    }
}