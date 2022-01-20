package com.surromo.millionaire.ui.adapter.home

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.surromo.millionaire.bean.home.Banner
import com.youth.banner.adapter.BannerAdapter

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/19
 * desc  : TODO
 */
class HomeBannerAdapter(var bannerList: MutableList<Banner>) : BannerAdapter<Banner, HomeBannerAdapter.BannerViewHolder>(bannerList) {

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val imageView = ImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }

    override fun onBindView(holder: BannerViewHolder, bean: Banner, position: Int, size: Int) {
        bean.imgRes.let { holder.imageView.setImageResource(it) }
    }

    inner class BannerViewHolder(var imageView: ImageView) : RecyclerView.ViewHolder(imageView)

}