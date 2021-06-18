package com.suromo.common.utils

import okio.Utf8
import java.io.*

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/6/18
 * desc  : TODO
 */
class MFile {

    companion object{

        fun exist(path: String):Boolean{
            return (File(path).exists())
        }

        fun saveText(content: String,path: String) : Boolean{
            if (content.isEmpty()){
                return try {
                    saveBytes(content.encodeToByteArray(),path)
                } catch (exception: UnsupportedEncodingException){
                    exception.printStackTrace()
                    false
                }
            }
            return false
        }

        fun saveBytes(bytes: ByteArray,path: String) :Boolean{
            var outputStream: FileOutputStream? = null
            try {
                val file = File(path)
                if (!file.exists()){
                    try {
                        file.createNewFile()
                    } catch (exception: IOException){
                        exception.printStackTrace()
                    }
                }
                outputStream = FileOutputStream(file)
                outputStream.write(bytes)
                outputStream.flush()
                return true
            } catch (exception: FileNotFoundException){
                exception.printStackTrace()
            } catch (exception: IOException){
                exception.printStackTrace()
            } finally {
                try {
                    outputStream?.close()
                } catch (exception: IOException){
                    exception.printStackTrace()
                }
            }
            return false
        }

//        fun create(path: String,name:String){
//            val file = File(path)
//            if (!file.exists()){
//                create(file)
//            }
//        }
//
//        fun create(file: File): Boolean{
//            var result = false
//            if (!file.exists()){
//                var tmpPath = file.parent +File.separator + System.currentTimeMillis()
//                var tmpFile = File(tmpPath)
//                if (!tmpFile.exists()){
//                    if (tmpFile.mkdirs()){
//                        result = tmpFile.renameTo(file)
//                        tmpFile.delete()
//                    }
//                }
//            }
//            return result
//        }

    }

}