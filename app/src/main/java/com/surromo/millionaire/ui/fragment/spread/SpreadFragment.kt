package com.surromo.millionaire.ui.fragment.spread

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentSettingBinding
import com.surromo.millionaire.databinding.FragmentSpreadBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */
class SpreadFragment : BaseFragment<FragmentSpreadBinding>(R.layout.fragment_spread) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.spread)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initData() {

    }

}