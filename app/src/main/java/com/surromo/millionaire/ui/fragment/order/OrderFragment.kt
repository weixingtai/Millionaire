package com.surromo.millionaire.ui.fragment.order

import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentOrderBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */
class OrderFragment : BaseFragment<FragmentOrderBinding>(R.layout.fragment_order) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.order)
    }

    override fun initData() {

    }

}