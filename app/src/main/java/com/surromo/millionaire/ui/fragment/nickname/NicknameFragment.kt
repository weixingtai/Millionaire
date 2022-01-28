package com.surromo.millionaire.ui.fragment.nickname

import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentNicknameBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/28
 * desc  : TODO
 */
class NicknameFragment : BaseFragment<FragmentNicknameBinding>(R.layout.fragment_nickname) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.nickname)
    }

    override fun initData() {
    }
}