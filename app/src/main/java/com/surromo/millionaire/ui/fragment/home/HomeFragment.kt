package com.surromo.millionaire.ui.fragment.home

import android.transition.AutoTransition
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.common.network.StateObserver
import com.surromo.millionaire.R
import com.surromo.millionaire.bean.home.BannerResponse
import com.surromo.millionaire.databinding.FragmentHomeBinding
import com.surromo.millionaire.ui.adapter.home.HomeBannerAdapter
import com.surromo.millionaire.ui.viewmodel.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.youth.banner.indicator.CircleIndicator

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/12/20
 * desc  : TODO
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var mTypeList : MutableList<String>
    private var mFragmentList: MutableList<Fragment> = mutableListOf()
    private val viewModel : HomeViewModel by viewModel()
    private val list: MutableList<BannerResponse> = ArrayList()
    var homeBannerAdapter : HomeBannerAdapter = HomeBannerAdapter(list)

    override fun initView() {
        mTypeList = mutableListOf(getString(R.string.order_dispatch),getString(R.string.order_taking))
        initViewPager()
        binding.mainToolbar.inflateMenu(R.menu.top_post_menu)

        val mSet = AutoTransition()
        mSet.duration = 300

        binding.llHomeLocation.setOnClickListener{
            viewModel.loadBanner()
        }

//        binding.discoverySv.setOnSearchClickListener {
//            TransitionManager.beginDelayedTransition(binding.discoverySv, mSet)
//        }
    }

    override fun initData() {
//        val bean1 = Banner(R.mipmap.ic_banner_demo1,"标题")
//        val bean2 = Banner(R.mipmap.ic_banner_demo2,"qq")

//        list.add(bean1)
//        list.add(bean2)

        mFragmentList.add(OrderDispatchFragment.newInstance())
        mFragmentList.add(OrderTakingFragment.newInstance())
    }

    override fun initObserve() {
        super.initObserve()
        viewModel.bannerLiveData.observe(this, object : StateObserver<MutableList<BannerResponse>>(null) {
            override fun onDataChange(data: MutableList<BannerResponse>?) {
                super.onDataChange(data)
                //绑定banner
                data?.let {
                    binding.homeBanner
                        .setAdapter(HomeBannerAdapter(it)).indicator = CircleIndicator(context)
                }
            }

            override fun onReload(v: View?) {
            }
        })
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