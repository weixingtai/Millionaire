package com.surromo.common.load

import android.content.Context
import android.view.View
import com.kingja.loadsir.callback.Callback
import com.surromo.common.R

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/17
 * desc  : 后台数据返回加载中的回调，主要用于LoadSir
 */
class LoadingCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_loading
    }

    override fun onViewCreate(context: Context?, view: View?) {
        super.onViewCreate(context, view)

    }

    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return true
    }

}