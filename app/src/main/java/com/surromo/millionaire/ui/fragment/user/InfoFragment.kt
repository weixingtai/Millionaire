package com.surromo.millionaire.ui.fragment.user

import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentInfoBinding
import com.surromo.millionaire.databinding.FragmentUserBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/27
 * desc  : TODO
 */
class InfoFragment : BaseFragment<FragmentInfoBinding>(R.layout.fragment_info) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.info)
    }

    override fun initData() {

    }

}