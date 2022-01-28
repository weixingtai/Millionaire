package com.surromo.millionaire.ui.fragment.profile

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentProfileBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/28
 * desc  : TODO
 */
class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.profile)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initData() {
    }
}