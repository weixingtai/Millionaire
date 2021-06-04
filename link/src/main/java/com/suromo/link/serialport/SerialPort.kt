package com.suromo.link.serialport

import java.io.File
import java.io.FileDescriptor
import java.io.IOException

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : 串口交互类，打开、关闭串口及修改文件权限
 */
open class SerialPort {

    init {
        System.loadLibrary("SerialPort")
    }

    /**
     * 文件设置最高权限 777 可读 可写 可执行
     *
     * @param file 文件
     * @return 权限修改是否成功
     */
    fun chmod777(file: File): Boolean {
        // 文件不存在
        if (!file.exists()) {
            return false
        }
        try {
            // 获取ROOT权限
            val su = Runtime.getRuntime().exec("/system/bin/su")
            // 修改文件属性为 [可读 可写 可执行]
            val cmd = "chmod 777 " + file.absolutePath + "\n" + "exit\n"
            su.outputStream.write(cmd.toByteArray())
            if (0 == su.waitFor() && file.canRead() && file.canWrite() && file.canExecute()) {
                return true
            }
        } catch (e: IOException) {
            // 没有ROOT权限
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return false
    }

    // 打开串口
    protected external fun open(path: String, baudRate: Int, flags: Int): FileDescriptor

    // 关闭串口
    protected external fun close()
}