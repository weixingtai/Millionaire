package com.surromo.millionaire.ui.fragment.home

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.surromo.common.base.bean.BasePagingResponse
import com.surromo.common.base.fragment.BaseFragment
import com.surromo.common.network.StateObserver
import com.surromo.millionaire.R
import com.surromo.millionaire.bean.home.OrderDispatchBean
import com.surromo.millionaire.databinding.FragmentHomeBinding
import com.surromo.millionaire.databinding.FragmentOrderDispatchBinding
import com.surromo.millionaire.ui.adapter.home.OrderDispatchAdapter
import com.surromo.millionaire.ui.viewmodel.home.OrderDispatchViewModel
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/19
 * desc  : TODO
 */
class OrderDispatchFragment : BaseFragment<FragmentOrderDispatchBinding>(R.layout.fragment_order_dispatch) {

    private val orderDispatchViewModel by viewModel<OrderDispatchViewModel>()
    private var pageNo = 1
    private var adapter = OrderDispatchAdapter(arrayListOf())
    private lateinit var orderDispatchBean: OrderDispatchBean
    companion object {
        fun newInstance(): OrderDispatchFragment {
            return OrderDispatchFragment()
        }
    }

    override fun initView() {
        binding.includeRv.refreshLayout.setOnRefreshLoadMoreListener(object :
            OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                pageNo = 1
                orderDispatchViewModel.getDispatchOrder(pageNo)
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                orderDispatchViewModel.getDispatchOrder(pageNo)
            }
        })

        binding.includeRv.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.includeRv.recyclerView.adapter = adapter
    }

    override fun initData() {

    }

    override fun initObserve() {
        super.initObserve()
        orderDispatchViewModel.orderDispatchData.observe(
            this,
            object :
                StateObserver<BasePagingResponse<ArrayList<OrderDispatchBean>>>(binding.includeRv.refreshLayout) {
                override fun onDataChange(data: BasePagingResponse<ArrayList<OrderDispatchBean>>?) {
                    super.onDataChange(data)

                    if (pageNo == 1) {
                        data?.datas?.add(0, orderDispatchBean)
                        adapter.setList(data?.datas)
                        binding.includeRv.refreshLayout.finishRefresh()
                    } else {
                        adapter.addData(data?.datas!!)
                        binding.includeRv.refreshLayout.finishLoadMore()
                    }

                    pageNo++
                }

                override fun onReload(v: View?) {
                }
            }
        )
    }
}