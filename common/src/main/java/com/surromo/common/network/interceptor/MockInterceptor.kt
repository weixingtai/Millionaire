package com.surromo.common.network.interceptor

import com.orhanobut.logger.Logger
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull

/**
 * author : weixingtai
 * e-mail : xingtai.wei@icloud.com
 * time  : 2022/2/6
 * desc  : TODO
 */
class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var response : Response
        var builder : Response.Builder = Response.Builder()
            .code(200)
            .message("")
            .request(chain.request())
            .protocol(Protocol.HTTP_1_0)
            .addHeader("content-type","application/json")
        var request: Request = chain.request()
        when {
            request.url.toString() == "https://www.wanandroid.com/home/banner/json" -> {
                Logger.d("request.url.equals(\"https://www.suromo.com/api/order/dispatch/1/json\")")
                var responseText = "{\"data\":[{\"desc\":\"一起来做个大保健吧\",\"id\":10,\"imagePath\":\"https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png\",\"isVisible\":1,\"order\":1,\"title\":\"一起来做个App吧\",\"type\":0,\"url\":\"https://www.wanandroid.com/blog/show/2\"},{\"desc\":\"\",\"id\":6,\"imagePath\":\"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png\",\"isVisible\":1,\"order\":1,\"title\":\"我们新增了一个常用导航Tab~\",\"type\":1,\"url\":\"https://www.wanandroid.com/navi\"},{\"desc\":\"\",\"id\":20,\"imagePath\":\"https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png\",\"isVisible\":1,\"order\":2,\"title\":\"flutter 中文社区 \",\"type\":1,\"url\":\"https://flutter.cn/\"}],\"errorCode\":0,\"errorMsg\":\"\"}"
                builder.body(ResponseBody.create("application/json".toMediaTypeOrNull(),responseText.toByteArray()))
                response = builder.build()
            }
            request.url.toString() == "https://www.wanandroid.com/home/order/dispatch/1/json" -> {
                Logger.d("request.url.equals(\"https://www.wanandroid.com/home/order/dispatch/1/json\")")
                var responseText = "{\n" +
                        "  \"data\": {\n" +
                        "    \"curPage\": 1,\n" +
                        "    \"datas\": [\n" +
                        "      {\n" +
                        "        \"id\": 1,\n" +
                        "        \"userImage\": \"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png\",\n" +
                        "        \"userName\": \"鸭梨西瓜大\",\n" +
                        "        \"userDistance\": \"0.2km\",\n" +
                        "        \"userProfile\": \"你是无意穿堂风，偏偏孤倨引山洪\",\n" +
                        "        \"orderTitle\": \"重庆邮电大学南门发传单\",\n" +
                        "        \"orderLabel\": \"文体\",\n" +
                        "        \"orderIntroduce\": \"今天下午学校南门发传单，有空的同学速来！\",\n" +
                        "        \"orderTime\": \"2022-01-19 00:52\",\n" +
                        "        \"orderLocation\": \"重庆邮电大学南门\",\n" +
                        "        \"orderReward\": \"200\",\n" +
                        "        \"orderPayWay\": \"日结\",\n" +
                        "        \"orderQuota\": 10,\n" +
                        "        \"orderImage\": \"https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png\",\n" +
                        "        \"orderCountdown\": \"2022-01-19 00:52\",\n" +
                        "        \"isOrderEnroll\": false,\n" +
                        "        \"isOrderFull\": false\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 2,\n" +
                        "        \"userImage\": \"https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png\",\n" +
                        "        \"userName\": \"小坏蛋\",\n" +
                        "        \"userDistance\": \"10.2km\",\n" +
                        "        \"userProfile\": \"心甘情愿给了的，就别耿耿于怀了。\",\n" +
                        "        \"orderTitle\": \"体育考试\",\n" +
                        "        \"orderLabel\": \"文体\",\n" +
                        "        \"orderIntroduce\": \"今天下午三四节，体育考试代考，体育尖子生来！\",\n" +
                        "        \"orderTime\": \"2022-02-06 10:52\",\n" +
                        "        \"orderLocation\": \"重庆邮电大学老操场\",\n" +
                        "        \"orderReward\": \"200\",\n" +
                        "        \"orderPayWay\": \"日结\",\n" +
                        "        \"orderQuota\": 2,\n" +
                        "        \"orderImage\": \"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png\",\n" +
                        "        \"orderCountdown\": \"2022-01-19 00:52\",\n" +
                        "        \"isOrderEnroll\": true,\n" +
                        "        \"isOrderFull\": false\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 3,\n" +
                        "        \"userImage\": \"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png\",\n" +
                        "        \"userName\": \"张大仙\",\n" +
                        "        \"userDistance\": \"7.5km\",\n" +
                        "        \"userProfile\": \"心有猛虎，细嗅蔷薇。\",\n" +
                        "        \"orderTitle\": \"王者荣耀陪玩\",\n" +
                        "        \"orderLabel\": \"游戏\",\n" +
                        "        \"orderIntroduce\": \"求萌妹子一起王者荣耀上分！\",\n" +
                        "        \"orderTime\": \"2022-02-05 08:45\",\n" +
                        "        \"orderLocation\": \"网上\",\n" +
                        "        \"orderReward\": \"30\",\n" +
                        "        \"orderPayWay\": \"日结\",\n" +
                        "        \"orderQuota\": 5,\n" +
                        "        \"orderImage\": \"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png\",\n" +
                        "        \"orderCountdown\": \"2022-01-19 00:52\",\n" +
                        "        \"isOrderEnroll\": true,\n" +
                        "        \"isOrderFull\": false\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"offset\": 0,\n" +
                        "    \"over\": false,\n" +
                        "    \"pageCount\": 2,\n" +
                        "    \"size\": 3,\n" +
                        "    \"total\": 6\n" +
                        "  },\n" +
                        "  \"errorCode\": 0,\n" +
                        "  \"errorMsg\": \"\"\n" +
                        "}"
                builder.body(ResponseBody.create("application/json".toMediaTypeOrNull(),responseText.toByteArray()))
                response = builder.build()
            }
            request.url.toString() == "https://www.wanandroid.com/home/order/dispatch/2/json" -> {
                Logger.d("request.url.equals(\"https://www.wanandroid.com/home/order/dispatch/2/json\")")
                var responseText = "{\n" +
                        "  \"data\": {\n" +
                        "    \"curPage\": 2,\n" +
                        "    \"datas\": [\n" +
                        "      {\n" +
                        "        \"id\": 1,\n" +
                        "        \"userImage\": \"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png\",\n" +
                        "        \"userName\": \"鸭梨西瓜大\",\n" +
                        "        \"userDistance\": \"0.2km\",\n" +
                        "        \"userProfile\": \"你是无意穿堂风，偏偏孤倨引山洪\",\n" +
                        "        \"orderTitle\": \"重庆邮电大学南门发传单\",\n" +
                        "        \"orderLabel\": \"文体\",\n" +
                        "        \"orderIntroduce\": \"今天下午学校南门发传单，有空的同学速来！\",\n" +
                        "        \"orderTime\": \"2022-01-19 00:52\",\n" +
                        "        \"orderLocation\": \"重庆邮电大学南门\",\n" +
                        "        \"orderReward\": \"200\",\n" +
                        "        \"orderPayWay\": \"日结\",\n" +
                        "        \"orderQuota\": 10,\n" +
                        "        \"orderImage\": \"https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png\",\n" +
                        "        \"orderCountdown\": \"2022-01-19 00:52\",\n" +
                        "        \"isOrderEnroll\": false,\n" +
                        "        \"isOrderFull\": false\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 2,\n" +
                        "        \"userImage\": \"https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png\",\n" +
                        "        \"userName\": \"小坏蛋\",\n" +
                        "        \"userDistance\": \"10.2km\",\n" +
                        "        \"userProfile\": \"心甘情愿给了的，就别耿耿于怀了。\",\n" +
                        "        \"orderTitle\": \"体育考试\",\n" +
                        "        \"orderLabel\": \"文体\",\n" +
                        "        \"orderIntroduce\": \"今天下午三四节，体育考试代考，体育尖子生来！\",\n" +
                        "        \"orderTime\": \"2022-02-06 10:52\",\n" +
                        "        \"orderLocation\": \"重庆邮电大学老操场\",\n" +
                        "        \"orderReward\": \"200\",\n" +
                        "        \"orderPayWay\": \"日结\",\n" +
                        "        \"orderQuota\": 2,\n" +
                        "        \"orderImage\": \"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png\",\n" +
                        "        \"orderCountdown\": \"2022-01-19 00:52\",\n" +
                        "        \"isOrderEnroll\": true,\n" +
                        "        \"isOrderFull\": false\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"id\": 3,\n" +
                        "        \"userImage\": \"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png\",\n" +
                        "        \"userName\": \"张大仙\",\n" +
                        "        \"userDistance\": \"7.5km\",\n" +
                        "        \"userProfile\": \"心有猛虎，细嗅蔷薇。\",\n" +
                        "        \"orderTitle\": \"王者荣耀陪玩\",\n" +
                        "        \"orderLabel\": \"游戏\",\n" +
                        "        \"orderIntroduce\": \"求萌妹子一起王者荣耀上分！\",\n" +
                        "        \"orderTime\": \"2022-02-05 08:45\",\n" +
                        "        \"orderLocation\": \"网上\",\n" +
                        "        \"orderReward\": \"30\",\n" +
                        "        \"orderPayWay\": \"日结\",\n" +
                        "        \"orderQuota\": 5,\n" +
                        "        \"orderImage\": \"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png\",\n" +
                        "        \"orderCountdown\": \"2022-01-19 00:52\",\n" +
                        "        \"isOrderEnroll\": true,\n" +
                        "        \"isOrderFull\": false\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"offset\": 0,\n" +
                        "    \"over\": false,\n" +
                        "    \"pageCount\": 2,\n" +
                        "    \"size\": 3,\n" +
                        "    \"total\": 6\n" +
                        "  },\n" +
                        "  \"errorCode\": 0,\n" +
                        "  \"errorMsg\": \"\"\n" +
                        "}"
                builder.body(ResponseBody.create("application/json".toMediaTypeOrNull(),responseText.toByteArray()))
                response = builder.build()
            }
            else -> {
                response = chain.proceed(request)
            }
        }
        return response
    }

}