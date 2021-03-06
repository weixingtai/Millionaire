package com.surromo.common.network

import android.net.ParseException
import android.view.View
import androidx.lifecycle.Observer
import com.google.gson.JsonParseException
import com.kingja.loadsir.callback.Callback
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.Convertor
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.orhanobut.logger.Logger
import com.surromo.common.base.bean.BaseResponse
import com.surromo.common.base.bean.DataState
import com.surromo.common.load.EmptyCallback
import com.surromo.common.load.ErrorCallback
import com.surromo.common.load.LoadingCallback
import com.surromo.common.util.ToastUtil
import org.json.JSONException
import retrofit2.HttpException
import java.io.InterruptedIOException
import java.net.ConnectException

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/23
 * desc  : TODO
 */
abstract class StateObserver<T>(view: View?) : Observer<BaseResponse<T>>, Callback.OnReloadListener {
    private var mLoadService: LoadService<Any>? = null

    init {
        if (view != null) {
            mLoadService = LoadSir.getDefault().register(view, this,
                Convertor<BaseResponse<T>> {
                    var resultCode: Class<out Callback> = SuccessCallback::class.java

                    when (it.dataState) {
                        //数据刚开始请求，loading
                        DataState.STATE_CREATE, DataState.STATE_LOADING -> resultCode = LoadingCallback::class.java
                        //请求成功
                        DataState.STATE_SUCCESS -> resultCode = SuccessCallback::class.java
                        //数据为空
                        DataState.STATE_EMPTY -> resultCode = EmptyCallback::class.java

                        DataState.STATE_FAILED, DataState.STATE_ERROR -> {
                            val error: Throwable? = it.error
                            onError(error)
                            //可以根据不同的错误类型，设置错误界面时的UI
                            if (error is HttpException) {
                                //网络错误
                            } else if (error is ConnectException) {
                                //无网络连接
                            } else if (error is InterruptedIOException) {
                                //连接超时
                            } else if (error is JsonParseException
                                || error is JSONException
                                || error is ParseException
                            ) {
                                //解析错误
                            } else {
                                //未知错误
                            }
                            resultCode = ErrorCallback::class.java
                        }

                        DataState.STATE_COMPLETED, DataState.STATE_UNKNOWN -> { }

                        else -> {}
                    }
                    resultCode
                }
            )
        }
    }

    override fun onChanged(t: BaseResponse<T>?) {

        when (t?.dataState){

            DataState.STATE_SUCCESS -> {
                //请求成功，数据不为null
                onDataChange(t.data)
            }

            DataState.STATE_EMPTY -> {
                //数据为空
                onDataEmpty()
            }

            DataState.STATE_FAILED, DataState.STATE_ERROR -> {
                //请求错误
                t.error?.let { onError(it) }
            }

            else -> {}
        }

        //加载不同状态界面
        Logger.d( "onChanged: mLoadService $mLoadService")

        //回调的时候直接传入转换器指定的数据类型。
        mLoadService?.showWithConvertor(t)
    }

    /**
     * 请求数据且数据不为空
     */
    open fun onDataChange(data: T?) {

    }

    /**
     * 请求成功，但数据为空
     */
    open fun onDataEmpty() {

    }

    /**
     * 请求错误
     */
    open fun onError(e: Throwable?) {

    }

    /**
     * 弹Toast
     */
    fun showToast(msg: String) {
        ToastUtil.show(msg)
    }
}