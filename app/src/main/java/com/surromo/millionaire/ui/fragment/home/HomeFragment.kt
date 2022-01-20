package com.surromo.millionaire.ui.fragment.home

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.bean.home.Banner
import com.surromo.millionaire.databinding.FragmentHomeBinding
import com.surromo.millionaire.ui.adapter.home.HomeBannerAdapter
import com.youth.banner.indicator.CircleIndicator

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/20
 * desc  : TODO
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val mTypeList = mutableListOf("派单","接单")
    private var mFragmentList: MutableList<Fragment> = mutableListOf()


    override fun initView() {

        initViewPager()
        binding.mainToolbar.inflateMenu(R.menu.top_post_menu)

        val mSet = AutoTransition()
        mSet.duration = 300


        binding.discoverySv.setOnSearchClickListener {
            TransitionManager.beginDelayedTransition(binding.discoverySv, mSet)
        }
    }

    override fun initData() {
        val bean1 = Banner(R.mipmap.ic_banner_demo1,"标题")
        val bean2 = Banner(R.mipmap.ic_banner_demo2,"qq")
        val list: MutableList<Banner> = ArrayList()
        list.add(bean1)
        list.add(bean2)
        binding.homeBanner.addBannerLifecycleObserver(this)
            .setAdapter(HomeBannerAdapter(list)).indicator = CircleIndicator(context)

        mFragmentList.add(OrderDispatchFragment.newInstance())
        mFragmentList.add(OrderTakingFragment.newInstance())
    }

    private fun initViewPager(){
        binding.discoveryVp.adapter = object : FragmentStateAdapter(this){

            override fun getItemCount() = mTypeList.size

            override fun createFragment(position: Int): Fragment {
                return mFragmentList[position]
            }
        }

        TabLayoutMediator(binding.discoveryTl,binding.discoveryVp){ tab, position ->
            tab.text = mTypeList[position]
        }.attach()
    }

}