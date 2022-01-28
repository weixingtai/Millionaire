package com.surromo.millionaire.ui.fragment.pay

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentPayBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */
class PayFragment : BaseFragment<FragmentPayBinding>(R.layout.fragment_pay) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.pay)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initData() {

    }

}