package com.surromo.millionaire.ui.fragment.region

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentRegionBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/28
 * desc  : TODO
 */
class RegionFragment : BaseFragment<FragmentRegionBinding>(R.layout.fragment_region) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.region)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initData() {
    }
}