package com.suromo.common.event

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : TODO
 */
class CommonEvent<T> : BaseEvent() {
    fun isSuccessful(): Boolean {
        return isSuccessful
    }

    fun setSuccessful(successful: Boolean): CommonEvent<*> {
        isSuccessful = successful
        return this
    }

    private var isSuccessful = false
    private var message: String? = null
    private var data: T? = null
    fun getResponseCode(): Int {
        return responseCode
    }

    fun setResponseCode(responseCode: Int): CommonEvent<*> {
        this.responseCode = responseCode
        return this
    }

    private var responseCode = 0
    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?): CommonEvent<*> {
        this.message = message
        return this
    }

    fun getData(): T? {
        return data
    }

    fun setData(data: T): CommonEvent<*> {
        this.data = data
        return this
    }

    companion object {
        fun getSimpleEvent(type: Int): CommonEvent<*> {
            val commonEvent: CommonEvent<*> = CommonEvent<Any?>()
            commonEvent.setSuccessful(true)
            commonEvent.setEventType(type)
            return commonEvent
        }
    }
}
