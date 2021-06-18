package com.suromo.common.utils

import android.os.Environment
import android.util.Log
import com.suromo.common.BuildConfig
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.transform.*
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

class MLog {



    companion object{
        private val DEBUG = BuildConfig.DEBUG
        var TAG = "MLog"
        var PATH = Environment.getExternalStorageDirectory().path +"/millionaire/mLog.txt"
        var SDF = SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS", Locale.CHINA)

        fun v(verbose: String){
            if (DEBUG) Log.d(TAG,verbose)
        }

        fun v(tag: String,verbose: String){
            if (DEBUG) Log.d(tag,verbose)
        }

        fun d(debug: String){
            if (DEBUG) Log.d(TAG,debug)
        }

        fun d(tag: String,debug: String){
            if (DEBUG) Log.d(tag,debug)
        }

        fun i(info: String){
            if (DEBUG) Log.i(TAG,info)
        }

        fun i(tag: String,info: String){
            if (DEBUG) Log.i(tag,info)
        }

        fun w(info: String){
            if (DEBUG) Log.w(TAG,info)
        }

        fun w(tag: String,info: String){
            if (DEBUG) Log.w(tag,info)
        }

        fun e(error: String){
            if (DEBUG) Log.e(TAG,error)
        }

        fun e(tag: String,error: String){
            if (DEBUG) Log.e(tag,error)
        }

        fun j(json: JSONObject){
            if (DEBUG){
                val message = json.toString(2)
                d(message)
            }
        }

        fun j(tag: String,json: JSONObject){
            if (DEBUG){
                val message = json.toString(2)
                d(tag,message)
            }
        }

        fun j(json: JSONArray){
            if (DEBUG){
                val message = json.toString(2)
                d(message)
            }
        }

        fun j(tag: String,json: JSONArray){
            if (DEBUG){
                val message = json.toString(2)
                d(tag,message)
            }
        }

        fun j(json: String){
            if (DEBUG){
                if (json.isEmpty()){
                    d("Empty/Null Json Content")
                }
                try {
                    val content = json.trim()
                    if (content.startsWith("{")) {
                        val jsonObject = JSONObject(content)
                        j(jsonObject)
                        return
                    }
                    if (content.startsWith("[")) {
                        val jsonArray = JSONArray(content)
                        j(jsonArray)
                        return
                    }
                    e("Invalid Json");
                } catch (e: JSONException) {
                    e("Invalid Json");
                }
            }
        }

        fun j(tag: String,json: String){
            if (DEBUG){
                if (json.isEmpty()){
                    d(tag,"Empty/Null Json Content")
                }
                try {
                    val content = json.trim()
                    if (content.startsWith("{")) {
                        val jsonObject = JSONObject(content)
                        j(jsonObject)
                        return
                    }
                    if (content.startsWith("[")) {
                        val jsonArray = JSONArray(content)
                        j(jsonArray)
                        return
                    }
                    e(tag,"Invalid Json");
                } catch (e: JSONException) {
                    e(tag,"Invalid Json");
                }
            }
        }

        fun x(xml: String){
            if (xml.isEmpty()){
                d("Empty/Null xml content")
                return
            }
            try {
                val xmlInput: Source = StreamSource(StringReader(xml))
                val xmlOutput = StreamResult(StringWriter())
                val transformer: Transformer = TransformerFactory.newInstance().newTransformer()
                transformer.setOutputProperty(OutputKeys.INDENT, "yes")
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")
                transformer.transform(xmlInput, xmlOutput)
                xmlOutput.writer.appendLine("\n")
                d(xmlOutput.writer.toString().replaceFirst(">", ">\n"))
            } catch (e: TransformerException) {
                e("Invalid xml");
            }
        }

        fun x(tag: String,xml: String){
            if (xml.isEmpty()){
                d(tag,"Empty/Null xml content")
                return
            }
            try {
                val xmlInput: Source = StreamSource(StringReader(xml))
                val xmlOutput = StreamResult(StringWriter())
                val transformer: Transformer = TransformerFactory.newInstance().newTransformer()
                transformer.setOutputProperty(OutputKeys.INDENT, "yes")
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")
                transformer.transform(xmlInput, xmlOutput)
                d(xmlOutput.writer.toString().replaceFirst(">", ">\n"))
            } catch (e: TransformerException) {
                e(tag,"Invalid xml");
            }
        }




        fun f(file: String){
            Log.d(TAG,file)
            val time = Date()
            val content = SDF.format(time) + "   " + TAG + "   " + file
            if (!File(PATH).exists()){
                File(PATH).mkdirs()
            }
            val mFile = File(PATH)
            try {
                val filerWriter = FileWriter(mFile,true)
                val bufWriter = BufferedWriter(filerWriter)
                bufWriter.write(content)
                bufWriter.newLine()
                bufWriter.close()
                filerWriter.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        fun f(tag: String,file: String){
            Log.d(tag,file)
            val time = Date()
            val content = SDF.format(time) + "   " + tag + "   " + file
            val log = File(PATH)
            try {
                val filerWriter = FileWriter(log,true)
                val bufWriter = BufferedWriter(filerWriter)
                bufWriter.write(content)
                bufWriter.newLine()
                bufWriter.close()
                filerWriter.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        fun b(bytes: ByteArray){

        }

        fun b(tag: String,bytes: ByteArray){

        }

    }



}