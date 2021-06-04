package com.suromo.link.serialport.bean

import com.orhanobut.logger.Logger
import java.io.File
import java.util.*

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : Device
 */
class Driver(val name: String, private val mDeviceRoot: String) {
    val devices: ArrayList<File>
        get() {
            val devices = ArrayList<File>()
            val dev = File("/dev")
            if (!dev.exists()) {
                Logger.d("getDevices: " + dev.absolutePath + " 不存在")
                return devices
            }
            if (!dev.canRead()) {
                Logger.d("getDevices: " + dev.absolutePath + " 没有读取权限")
                return devices
            }
            val files = dev.listFiles()
            for (i in files?.indices!!) {
                if (files[i].absolutePath.startsWith(mDeviceRoot)) {
                    Logger.d("Found new device: " + files[i])
                    devices.add(files[i])
                }
            }
            return devices
        }
}