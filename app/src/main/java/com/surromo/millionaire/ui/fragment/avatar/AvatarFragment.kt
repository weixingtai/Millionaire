package com.surromo.millionaire.ui.fragment.avatar

import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentAvatarBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/28
 * desc  : TODO
 */
class AvatarFragment : BaseFragment<FragmentAvatarBinding>(R.layout.fragment_avatar) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.avatar)
    }

    override fun initData() {
    }
}