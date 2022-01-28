package com.surromo.millionaire.ui.fragment.setting

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentSettingBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */
class SettingFragment : BaseFragment<FragmentSettingBinding>(R.layout.fragment_setting) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.setting)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initData() {

    }

}