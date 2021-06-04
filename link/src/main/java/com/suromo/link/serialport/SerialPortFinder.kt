package com.suromo.link.serialport

import com.orhanobut.logger.Logger
import com.suromo.link.serialport.bean.Device
import com.suromo.link.serialport.bean.Driver
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.io.LineNumberReader
import java.util.*
/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/1
 * desc  : 串口交互类，打开、关闭串口及修改文件权限
 */
class SerialPortFinder {
    /**
     * 获取 Drivers
     *
     * @return Drivers
     * @throws IOException IOException
     */
    @get:Throws(IOException::class)
    private val drivers: ArrayList<Driver>
        private get() {
            val drivers = ArrayList<Driver>()
            val lineNumberReader = LineNumberReader(FileReader(DRIVERS_PATH))
            var readLine: String
            while (lineNumberReader.readLine().also { readLine = it } != null) {
                val driverName = readLine.substring(0, 0x15).trim { it <= ' ' }
                val fields = readLine.split(" +").toTypedArray()
                if (fields.size >= 5 && fields[fields.size - 1] == SERIAL_FIELD) {
                    Logger.d("Found new driver " + driverName + " on " + fields[fields.size - 4])
                    drivers.add(Driver(driverName, fields[fields.size - 4]))
                }
            }
            return drivers
        }

    /**
     * 获取串口
     *
     * @return 串口
     */
    val devices: ArrayList<Device>
        get() {
            val devices = ArrayList<Device>()
            try {
                val drivers = drivers
                for (driver in drivers) {
                    val driverName = driver.name
                    val driverDevices = driver.devices
                    for (file in driverDevices) {
                        val devicesName = file.name
                        devices.add(Device(devicesName, driverName, file))
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return devices
        }

    companion object {
        private const val DRIVERS_PATH = "/proc/tty/drivers"
        private const val SERIAL_FIELD = "serial"
    }

    init {
        val file = File(DRIVERS_PATH)
        val b = file.canRead()
        Logger.i("SerialPortFinder: file.canRead() = $b")
    }
}