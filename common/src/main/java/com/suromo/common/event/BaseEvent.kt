package com.suromo.common.event

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : TODO
 */
open class BaseEvent {
    private var eventType = 0
    fun getEventType(): Int {
        return eventType
    }

    fun setEventType(eventType: Int): BaseEvent {
        this.eventType = eventType
        return this
    }
}
