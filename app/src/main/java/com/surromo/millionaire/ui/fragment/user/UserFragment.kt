package com.surromo.millionaire.ui.fragment.user

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentUserBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/20
 * desc  : TODO
 */
class UserFragment : BaseFragment<FragmentUserBinding>(R.layout.fragment_user) {
    override fun initView() {

        binding.rlUserInfo.setOnClickListener {
            findNavController().navigate(R.id.action_user_to_info)
        }

        binding.mtvUserPay.setOnClickListener {
            findNavController().navigate(R.id.action_user_to_pay)
        }

        binding.mtvUserHomePage.setOnClickListener {
            findNavController().navigate(R.id.action_user_to_homepage)
        }

        binding.mtvUserOrder.setOnClickListener {
            findNavController().navigate(R.id.action_user_to_order)
        }

        binding.mtvUserTrade.setOnClickListener {
            findNavController().navigate(R.id.action_user_to_trade)
        }

        binding.mtvUserIdentification.setOnClickListener {
            findNavController().navigate(R.id.action_user_to_identification)
        }

        binding.mtvUserSetting.setOnClickListener {
            findNavController().navigate(R.id.action_user_to_setting)
        }

        binding.mtvUserSpread.setOnClickListener {
            findNavController().navigate(R.id.action_user_to_spread)
        }

    }

    override fun initData() {

    }

}