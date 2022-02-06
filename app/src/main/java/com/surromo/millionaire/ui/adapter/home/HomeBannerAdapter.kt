package com.surromo.millionaire.ui.adapter.home

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.orhanobut.logger.Logger
import com.surromo.millionaire.bean.home.Banner
import com.youth.banner.adapter.BannerAdapter

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/1/19
 * desc  : TODO
 */
class HomeBannerAdapter(var bannerList: MutableList<Banner>) : BannerAdapter<Banner, HomeBannerAdapter.BannerViewHolder>(bannerList) {

    fun addBannerList(list: MutableList<Banner>) {
        bannerList = list
    }

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val imageView = ImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }

    override fun onBindView(holder: BannerViewHolder, bean: Banner, position: Int, size: Int) {
//        var imageLoader: ImageLoader = ImageLoader.getInstance()
        bean.imagePath.let {
            Logger.d("HomeBannerAdapter->imagePath:$it")
//            imageLoader.displayImage(it,holder.imageView)
        }
    }

    inner class BannerViewHolder(var imageView: ImageView) : RecyclerView.ViewHolder(imageView)

}