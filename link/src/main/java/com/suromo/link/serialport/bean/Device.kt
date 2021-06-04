package com.suromo.link.serialport.bean

import java.io.File
import java.io.Serializable

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : Device
 */
class Device(
    var name: String,
    var root: String,
    var file: File
) : Serializable