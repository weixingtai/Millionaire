package com.surromo.millionaire.ui.fragment.home

import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.millionaire.R
import com.surromo.millionaire.databinding.FragmentOrderDispatchBinding
import com.surromo.millionaire.ui.adapter.home.OrderDispatchAdapter
import com.surromo.millionaire.ui.viewmodel.home.OrderDispatchViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/19
 * desc  : TODO
 */
class OrderDispatchFragment(var llHomeBanner: LinearLayout) : BaseFragment<FragmentOrderDispatchBinding>(R.layout.fragment_order_dispatch) {

    private val orderDispatchViewModel by viewModel<OrderDispatchViewModel>()
    private var adapter = OrderDispatchAdapter()
    companion object {
        fun newInstance(llHomeBanner: LinearLayout): OrderDispatchFragment {
            return OrderDispatchFragment(llHomeBanner)
        }
    }

    override fun initView() {
        binding.includeRv.recyclerView.adapter = adapter
        binding.includeRv.refreshLayout.setOnRefreshLoadMoreListener(object :
            OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                llHomeBanner.visibility = View.VISIBLE
                adapter.refresh()
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                llHomeBanner.visibility = View.GONE
                adapter.refresh()
            }

        })
        binding.includeRv.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.includeRv.recyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }

    override fun initData() {

    }

    override fun lazyLoadData() {
        lifecycleScope.launchWhenCreated {
            orderDispatchViewModel.getDispatchOrder().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}