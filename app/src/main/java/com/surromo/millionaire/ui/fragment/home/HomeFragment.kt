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
import kotlinx.android.synthetic.main.fragment_home.*

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
    private var homeBannerAdapter = HomeBannerAdapter(list)

    override fun initView() {
        mTypeList = mutableListOf(getString(R.string.order_dispatch),getString(R.string.order_taking))
        initViewPager()
        binding.mainToolbar.inflateMenu(R.menu.top_post_menu)
        binding.homeBanner.setAdapter(homeBannerAdapter).indicator = CircleIndicator(context)

        val mSet = AutoTransition()
        mSet.duration = 300

        binding.llHomeLocation.setOnClickListener{
            viewModel.loadBanner()
        }
    }

    override fun initData() {
        mFragmentList.add(OrderDispatchFragment.newInstance(binding.llHomeBanner))
        mFragmentList.add(OrderTakingFragment.newInstance())
    }

    override fun initObserve() {
        super.initObserve()
        viewModel.bannerLiveData.observe(this, object : StateObserver<MutableList<BannerResponse>>(null) {
            override fun onDataChange(data: MutableList<BannerResponse>?) {
                super.onDataChange(data)
                //绑定banner
                data?.let {
                    homeBannerAdapter.setDatas(it)
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

    override fun lazyLoadData() {
        super.lazyLoadData()
        viewModel.loadBanner()
    }
}