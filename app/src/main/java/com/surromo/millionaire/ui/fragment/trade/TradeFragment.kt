package com.surromo.millionaire.ui.fragment.trade

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentOrderBinding
import com.surromo.millionaire.databinding.FragmentTradeBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */
class TradeFragment : BaseFragment<FragmentTradeBinding>(R.layout.fragment_trade) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.trade)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun initData() {

    }

}