package com.surromo.millionaire.ui.fragment.privacy

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentPrivacyBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/28
 * desc  : TODO
 */
class PrivacyFragment : BaseFragment<FragmentPrivacyBinding>(R.layout.fragment_privacy) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.privacy_agreement)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initData() {

    }

}