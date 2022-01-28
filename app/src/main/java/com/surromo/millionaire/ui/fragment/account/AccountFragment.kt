package com.surromo.millionaire.ui.fragment.account

import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentAccountBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/28
 * desc  : TODO
 */
class AccountFragment : BaseFragment<FragmentAccountBinding>(R.layout.fragment_account) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.account)
    }

    override fun initData() {
    }
}