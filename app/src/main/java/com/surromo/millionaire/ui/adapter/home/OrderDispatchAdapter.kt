package com.surromo.millionaire.ui.adapter.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.surromo.millionaire.R
import com.surromo.millionaire.bean.home.OrderDispatchResponse

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/20
 * desc  : TODO
 */
class OrderDispatchAdapter(list: ArrayList<OrderDispatchResponse>) :
    BaseQuickAdapter<OrderDispatchResponse, BaseViewHolder>(R.layout.item_order_dispatch,list) {

    override fun convert(holder: BaseViewHolder, item: OrderDispatchResponse) {
        item.run {
            holder.setText(R.id.tv_dispatch_user_name,userName)
//            holder.setText(R.id.tv_dispatch_user_distance,userDistance)
//            holder.setText(R.id.tv_dispatch_user_profile,userProfile)
            holder.setText(R.id.tv_dispatch_order_title,orderTitle)
            holder.setText(R.id.tv_dispatch_order_introduce,orderIntroduce)
        }


    }

}