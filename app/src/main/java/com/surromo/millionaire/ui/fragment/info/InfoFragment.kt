package com.surromo.millionaire.ui.fragment.info

import androidx.navigation.fragment.findNavController
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentInfoBinding
import com.surromo.millionaire.databinding.FragmentUserBinding

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/27
 * desc  : TODO
 */
class InfoFragment : BaseFragment<FragmentInfoBinding>(R.layout.fragment_info) {
    override fun initView() {
        binding.inclTitle.tvPageTitle.setText(R.string.info)
        binding.inclTitle.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.rlInfoAvatar.setOnClickListener {
            findNavController().navigate(R.id.action_info_to_avatar)
        }
        binding.mtvInfoNickname.setOnClickListener {
            findNavController().navigate(R.id.action_info_to_nickname)
        }
        binding.mtvInfoAccount.setOnClickListener {
            findNavController().navigate(R.id.action_info_to_account)
        }
        binding.mtvInfoGender.setOnClickListener {
            findNavController().navigate(R.id.action_info_to_gender)

        }
        binding.mtvInfoRegion.setOnClickListener {
            findNavController().navigate(R.id.action_info_to_region)
        }
        binding.mtvInfoProfile.setOnClickListener {
            findNavController().navigate(R.id.action_info_to_profile)
        }
        binding.rlInfoQrCode.setOnClickListener {
            findNavController().navigate(R.id.action_info_to_qr_code)
        }
    }

    override fun initData() {

    }

}