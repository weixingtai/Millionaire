package com.surromo.millionaire.ui.viewmodel.home

import androidx.lifecycle.viewModelScope
import com.surromo.common.base.bean.BasePagingResponse
import com.surromo.common.base.bean.StateLiveData
import com.surromo.common.base.viewmodel.BaseViewModel
import com.surromo.millionaire.bean.home.OrderDispatchBean
import com.surromo.millionaire.net.repository.HomeRepository
import kotlinx.coroutines.launch

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/24
 * desc  : TODO
 */

class OrderDispatchViewModel(private val repository: HomeRepository) : BaseViewModel() {

    var orderDispatchData = StateLiveData<BasePagingResponse<ArrayList<OrderDispatchBean>>>()

    fun getDispatchOrder(pageNo:Int,isShowLoading : Boolean = false) {

        viewModelScope.launch {
            repository.getDispatchOrder(
                pageNo,
                orderDispatchData,
                isShowLoading
            )
        }
    }
}