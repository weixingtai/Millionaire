package com.surromo.millionaire.ui.fragment.qrcode

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentQrCodeBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/28
 * desc  : TODO
 */
class QrCodeFragment : BaseFragment<FragmentQrCodeBinding>(R.layout.fragment_qr_code) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.qr_code)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

    }

    override fun initData() {
    }
}