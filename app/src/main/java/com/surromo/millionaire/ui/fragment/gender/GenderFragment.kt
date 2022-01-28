package com.surromo.millionaire.ui.fragment.gender

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentGenderBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/28
 * desc  : TODO
 */
class GenderFragment : BaseFragment<FragmentGenderBinding>(R.layout.fragment_gender) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.gender)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initData() {
    }
}