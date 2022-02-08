package com.surromo.common.base.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.youth.banner.Banner

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/14
 * desc  : Fragment基类
 */
abstract class BaseFragment<VDB: ViewDataBinding>(@LayoutRes val resId: Int) : Fragment(resId) {

    lateinit var binding: VDB
    private val handler = Handler()
    //是否第一次加载
    private var isFirst: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, resId, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        isFirst = true
        initView()
        initData()
        initObserve()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        onLoadData()
    }

    abstract fun initView()
    abstract fun initData()
    open fun initObserve(){}

    /**
     * 是否需要懒加载
     */
    private fun onLoadData() {
//        Log.e("wzy","${this.javaClass.name} --  ${lifecycle.currentState}")
        if (lifecycle.currentState == Lifecycle.State.STARTED && isFirst) {

            // 延迟加载 防止 切换动画还没执行完毕时数据就已经加载好了，这时页面会有渲染卡顿
            handler.postDelayed({
                lazyLoadData()
                isFirst = false
            }, lazyLoadTime())
        }
    }

    /**
     * 懒加载
     */
    open fun lazyLoadData(){}

    /**
     * 延迟加载 防止 切换动画还没执行完毕时数据就已经加载好了，这时页面会有渲染卡顿  bug
     * 这里传入你想要延迟的时间，延迟时间可以设置比转场动画时间长一点 单位： 毫秒
     * 不传默认 300毫秒
     * @return Long
     */
    open fun lazyLoadTime(): Long {
        return 300
    }
}