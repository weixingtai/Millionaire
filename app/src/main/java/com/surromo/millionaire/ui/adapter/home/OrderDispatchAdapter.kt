package com.surromo.millionaire.ui.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.nostra13.universalimageloader.core.ImageLoader
import com.surromo.millionaire.R
import com.surromo.millionaire.bean.home.OrderDispatchResponse
import com.surromo.millionaire.databinding.ItemOrderDispatchBinding
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/20
 * desc  : TODO
 */

class OrderDispatchAdapter : PagingDataAdapter<OrderDispatchResponse, RecyclerView.ViewHolder>(
    differCallback
) {

    private var collectClickListener : ((Int,OrderDispatchResponse) -> Unit)? = null

    fun setCollectClick( listener :(Int,OrderDispatchResponse) -> Unit){
        collectClickListener=listener
    }

    companion object {
        const val TYPE_BANNER = 0
        const val TYPE_ARTICLE = 1

        val differCallback = object : DiffUtil.ItemCallback<OrderDispatchResponse>() {
            override fun areItemsTheSame(oldItem: OrderDispatchResponse, newItem: OrderDispatchResponse): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: OrderDispatchResponse, newItem: OrderDispatchResponse): Boolean {
                return oldItem == newItem
            }
        }
    }

    var listener: ((OrderDispatchResponse) -> Unit)? = null

    fun setOnItemClickListener(listener : (OrderDispatchResponse) -> Unit){
        this.listener = listener
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            getItem(position)?.let { item ->
                (holder as DispatchOrderViewHolder).bindData(item)
                holder.itemView.setOnClickListener { listener?.invoke(item) }

            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return DispatchOrderViewHolder(
                ItemOrderDispatchBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
    }

    override fun getItemViewType(position: Int): Int {
        return TYPE_ARTICLE
    }

    internal class DispatchOrderViewHolder(val binding: ItemOrderDispatchBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bindData(data: OrderDispatchResponse){
            binding.rivDispatchUserAvatar.load(data.userImage)
            binding.rivDispatchOrderImg.load(data.orderImage)
            binding.tvDispatchUserName.text = data.userName
            binding.tvDispatchUserDistance.text = data.userDistance
            binding.tvDispatchUserProfile.text = data.userProfile
            binding.tvDispatchOrderTitle.text = data.orderTitle
            binding.tvDispatchOrderIntroduce.text = data.orderIntroduce
            binding.tvDispatchOrderTime.text = data.orderTime
            binding.tvDispatchOrderLabel.setText(data.orderLabel)
            binding.tvDispatchOrderLocation.text = data.orderLocation
            binding.tvDispatchOrderPayWay.text = data.orderPayWay
            binding.tvDispatchOrderQuota.text = data.orderQuota.toString()
            binding.tvDispatchOrderReward.text = data.orderReward
//            binding.tvDispatchOrderCountDown.text = data.orderCountDown

        }
    }



}