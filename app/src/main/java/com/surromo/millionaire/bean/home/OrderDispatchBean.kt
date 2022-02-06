package com.surromo.millionaire.bean.home

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class OrderDispatchBean(
    var userImage: String,
    var userName: String,
    var userDistance: String,
    var userProfile: String,
    var orderTitle: String,
    var orderLabel: String,
    var orderIntroduce: String,
    var orderTime: String,
    var orderLocation: String,
    var orderReward: String,
    var orderPayWay: String,
    var orderQuota: Int,
    var orderImage: String,
    var orderCountDown: String,
    var isOrderEnroll: Boolean,
    var isOrderFull: Boolean

) : Parcelable