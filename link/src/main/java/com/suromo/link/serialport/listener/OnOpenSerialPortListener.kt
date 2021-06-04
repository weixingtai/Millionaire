package com.suromo.link.serialport.listener

import java.io.File

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : Device
 */
interface OnOpenSerialPortListener {
    fun onSuccess(device: File)
    fun onFail(device: File, status: Status)
    enum class Status {
        NO_READ_WRITE_PERMISSION, OPEN_FAIL
    }
}