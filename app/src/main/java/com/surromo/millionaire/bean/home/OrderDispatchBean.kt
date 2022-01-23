package com.surromo.millionaire.bean.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */
@Parcelize
data class OrderDispatchBean(

    var userImage: String,
    var userName: String,
    var userDistance: Int,
    var userProfile: String,
    var orderTitle: String,
    var orderLabel: String,
    var orderIntroduce: String,
    var orderTime: Date,
    var orderLocation: String,
    var orderReward: Int,
    var orderPayWay: String,
    var orderQuota: Int,
    var orderImage: String,
    var orderCountDown: String,
    var isOrderEnroll: Boolean,
    var isOrderFull: Boolean

) : Parcelable