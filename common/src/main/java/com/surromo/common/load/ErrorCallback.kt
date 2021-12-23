package com.surromo.common.load

import com.kingja.loadsir.callback.Callback
import com.surromo.common.R

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/17
 * desc  : 后台数据返回为错误的回调，主要用于LoadSir
 */
class ErrorCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_error
    }

}