package com.surromo.millionaire.ui.fragment.identification

import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentIdentificationBinding
import com.surromo.millionaire.databinding.FragmentPayBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */
class IdentificationFragment : BaseFragment<FragmentIdentificationBinding>(R.layout.fragment_identification) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.identification)
    }

    override fun initData() {

    }

}