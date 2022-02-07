package com.surromo.millionaire.bean.home

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2021/4/22
 * desc  : 首页轮播图实体类
 *
 *
{
"data":{
"coinCount":2009,
"level":21,
"nickname":"",
"rank":"1021",
"userId":102593,
"username":"1**02196601"
},
"errorCode":0,
"errorMsg":""
}
 */
data class BannerResponse(
    var desc: String = "",
    var id: Int = 0,
    var imagePath: String = "",
    var isVisible: Int = 0,
    var order: Int = 0,
    var title: String = "",
    var type: Int = 0,
    var url: String = ""
)