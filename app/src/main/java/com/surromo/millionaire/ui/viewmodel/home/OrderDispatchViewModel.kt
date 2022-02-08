package com.surromo.millionaire.ui.viewmodel.home

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.surromo.common.base.bean.BasePagingResponse
import com.surromo.common.base.bean.StateLiveData
import com.surromo.common.base.viewmodel.BaseViewModel
import com.surromo.millionaire.bean.home.OrderDispatchResponse
import com.surromo.millionaire.net.repository.HomeRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */

class OrderDispatchViewModel(private val repository: HomeRepository) : BaseViewModel() {

    var orderDispatchResponse = StateLiveData<BasePagingResponse<ArrayList<OrderDispatchResponse>>>()

//    fun getDispatchOrder(pageNo:Int,isShowLoading : Boolean = false) {
//
//        viewModelScope.launch {
//            repository.getDispatchOrder(
//                pageNo,
//                orderDispatchResponse,
//                isShowLoading
//            )
//        }
//    }

    fun  getDispatchOrder(): Flow<PagingData<OrderDispatchResponse>> =
        repository.getDispatchOrder().cachedIn(viewModelScope)
}