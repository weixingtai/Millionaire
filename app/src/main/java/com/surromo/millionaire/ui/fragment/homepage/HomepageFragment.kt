package com.surromo.millionaire.ui.fragment.homepage

import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentHomepageBinding
import com.surromo.millionaire.databinding.FragmentPayBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */
class HomepageFragment : BaseFragment<FragmentHomepageBinding>(R.layout.fragment_homepage) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.homepage)
    }

    override fun initData() {

    }

}