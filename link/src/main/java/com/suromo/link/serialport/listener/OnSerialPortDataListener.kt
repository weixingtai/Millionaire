package com.suromo.link.serialport.listener

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : Device
 */
interface OnSerialPortDataListener {
    /**
     * 数据接收
     *
     * @param bytes 接收到的数据
     */
    fun onDataReceived(bytes: ByteArray)

    /**
     * 数据发送
     *
     * @param bytes 发送的数据
     */
    fun onDataSent(bytes: ByteArray)
}