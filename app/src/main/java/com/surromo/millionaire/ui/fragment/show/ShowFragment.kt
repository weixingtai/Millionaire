package com.surromo.millionaire.ui.fragment.show

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentShowBinding
import com.surromo.millionaire.databinding.FragmentSpreadBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/28
 * desc  : TODO
 */
class ShowFragment : BaseFragment<FragmentShowBinding>(R.layout.fragment_show) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.show_setting)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initData() {

    }

}