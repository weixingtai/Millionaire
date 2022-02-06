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
            request.url.toString() == "https://www.wanandroid.com/lg/coin/list/1/json" -> {
                Logger.d("request.url.equals(\"https://www.suromo.com/api/order/dispatch/1/json\")")
                var responseText = "{\"data\":{\"curPage\":1,\"datas\":[{\"coinCount\":34,\"date\":1644119225000,\"desc\":\"2022-02-06 11:47:05 傻逼 , 积分：120000 + 220000\",\"id\":571693,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":33,\"date\":1643162058000,\"desc\":\"2022-01-26 09:54:18 傻逼 , 积分：12 + 21\",\"id\":568738,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":32,\"date\":1642916970000,\"desc\":\"2022-01-23 13:49:30 签到 , 积分：12 + 20\",\"id\":567347,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":31,\"date\":1641967489000,\"desc\":\"2022-01-12 14:04:49 签到 , 积分：12 + 19\",\"id\":562000,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":30,\"date\":1641284071000,\"desc\":\"2022-01-04 16:14:31 签到 , 积分：12 + 18\",\"id\":557835,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":29,\"date\":1640920864000,\"desc\":\"2021-12-31 11:21:04 签到 , 积分：12 + 17\",\"id\":556386,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":28,\"date\":1640843123000,\"desc\":\"2021-12-30 13:45:23 签到 , 积分：12 + 16\",\"id\":555808,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":27,\"date\":1640740503000,\"desc\":\"2021-12-29 09:15:03 签到 , 积分：12 + 15\",\"id\":554919,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":26,\"date\":1640656536000,\"desc\":\"2021-12-28 09:55:36 签到 , 积分：12 + 14\",\"id\":554329,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":25,\"date\":1640598293000,\"desc\":\"2021-12-27 17:44:53 签到 , 积分：12 + 13\",\"id\":554019,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":24,\"date\":1637112098000,\"desc\":\"2021-11-17 09:21:38 签到 , 积分：12 + 12\",\"id\":530965,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":23,\"date\":1636958678000,\"desc\":\"2021-11-15 14:44:38 签到 , 积分：12 + 11\",\"id\":530029,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":22,\"date\":1636704736000,\"desc\":\"2021-11-12 16:12:16 签到 , 积分：12 + 10\",\"id\":528638,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":21,\"date\":1636186350000,\"desc\":\"2021-11-06 16:12:30 签到 , 积分：12 + 9\",\"id\":525035,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":20,\"date\":1635902690000,\"desc\":\"2021-11-03 09:24:50 签到 , 积分：12 + 8\",\"id\":522872,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":19,\"date\":1635755188000,\"desc\":\"2021-11-01 16:26:28 签到 , 积分：12 + 7\",\"id\":521898,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":18,\"date\":1635298947000,\"desc\":\"2021-10-27 09:42:27 签到 , 积分：12 + 6\",\"id\":519123,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":17,\"date\":1635236464000,\"desc\":\"2021-10-26 16:21:04 签到 , 积分：12 + 5\",\"id\":518804,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":16,\"date\":1635131275000,\"desc\":\"2021-10-25 11:07:55 签到 , 积分：12 + 4\",\"id\":518004,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"},{\"coinCount\":15,\"date\":1634988127000,\"desc\":\"2021-10-23 19:22:07 签到 , 积分：12 + 3\",\"id\":517346,\"reason\":\"签到\",\"type\":1,\"userId\":102593,\"userName\":\"16602196601\"}],\"offset\":0,\"over\":false,\"pageCount\":5,\"size\":20,\"total\":85},\"errorCode\":0,\"errorMsg\":\"\"}"
                builder.body(ResponseBody.create("application/json".toMediaTypeOrNull(),responseText.toByteArray()))
                response = builder.build()
            }
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
                        "        \"userImage\": \"\",\n" +
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
                        "        \"orderImage\": \"https://www.wanandroid.com/wenda/show/21251\",\n" +
                        "        \"orderCountdown\": \"2022-01-19 00:52\",\n" +
                        "        \"isOrderEnroll\": false,\n" +
                        "        \"isOrderFull\": false\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"userImage\": \"\",\n" +
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
                        "        \"orderImage\": \"https://www.wanandroid.com/wenda/show/21251\",\n" +
                        "        \"orderCountdown\": \"2022-01-19 00:52\",\n" +
                        "        \"isOrderEnroll\": true,\n" +
                        "        \"isOrderFull\": false\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"userImage\": \"\",\n" +
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
                        "        \"orderImage\": \"https://www.wanandroid.com/wenda/show/21251\",\n" +
                        "        \"orderCountdown\": \"2022-01-19 00:52\",\n" +
                        "        \"isOrderEnroll\": true,\n" +
                        "        \"isOrderFull\": false\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"offset\": 0,\n" +
                        "    \"over\": false,\n" +
                        "    \"pageCount\": 5,\n" +
                        "    \"size\": 20,\n" +
                        "    \"total\": 85\n" +
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