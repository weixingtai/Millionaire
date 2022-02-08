package com.surromo.millionaire.ui.adapter.home

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.orhanobut.logger.Logger
import com.surromo.millionaire.R
import com.surromo.millionaire.bean.home.BannerResponse
import com.youth.banner.adapter.BannerAdapter

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/19
 * desc  : TODO
 */
class HomeBannerAdapter(bannerResponseList: MutableList<BannerResponse>) : BannerAdapter<BannerResponse, HomeBannerAdapter.BannerViewHolder>(bannerResponseList) {

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val imageView = ImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }

    override fun onBindView(holder: BannerViewHolder, bean: BannerResponse, position: Int, size: Int) {
        bean.imagePath.let { holder.imageView.load(it){placeholder(R.drawable.ic_qr_code)} }
    }

    inner class BannerViewHolder(var imageView: ImageView) : RecyclerView.ViewHolder(imageView)

}