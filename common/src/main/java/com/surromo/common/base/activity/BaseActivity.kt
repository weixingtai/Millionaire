package com.surromo.common.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/9
 * desc  : TODO
 */
abstract class BaseActivity<DB: ViewDataBinding>(
    @LayoutRes val resId: Int): AppCompatActivity() {

    lateinit var binding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBind()
        initObserve()
        initView()
        initData()
    }

    private fun initDataBind() {
        binding = DataBindingUtil.setContentView(this, resId)
        binding.lifecycleOwner = this
    }

    open fun initObserve(){}
    abstract fun initView()
    abstract fun initData()
}