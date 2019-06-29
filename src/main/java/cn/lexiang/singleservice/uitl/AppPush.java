package cn.lexiang.singleservice.uitl;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.uitls.AppConditions;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Qfeng
 * @Date 2019-04-11 09:40:40
 */
public class AppPush {
    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = "9xXas5hg8E8yb7Fxu9YzU4";
    private static String appKey = "rnjvfENl3G9dtUaGllNnC4";
    private static String masterSecret = "QYmfIQVHTlATCF6VClW559";

    private static String user_appId = "9xXas5hg8E8yb7Fxu9YzU4";
    private static String user_appKey = "rnjvfENl3G9dtUaGllNnC4";
    private static String user_masterSecret = "QYmfIQVHTlATCF6VClW559";

    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void serviceSend(String title, String text) {
        IGtPush push = new IGtPush(url, "R6G1yYoNVQ6yxpp1g7HWk6", "CsFXKOUVSo9FRnmswqpqB4");





        NotificationTemplate template = new NotificationTemplate();
        // 设置APPID与APPKEY
        template.setAppId("V0LFRtylAh8tZLyQvrsFG4");
        template.setAppkey("R6G1yYoNVQ6yxpp1g7HWk6");
        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(1);
        template.setTransmissionContent("请输入您要透传的内容");
        // 设置定时展示时间
        // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");

        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle(title);
        style.setText(text);
        // 配置通知栏图标
//        style.setLogo("icon.png");
        // 配置通知栏网络图标
//        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template.setStyle(style);



        List<String> appIds = new ArrayList();
        appIds.add("V0LFRtylAh8tZLyQvrsFG4");


        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);

        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());
    }


    public static void eventSend(String title, String text, String time) throws ParseException {
        IGtPush push = new IGtPush(url, user_appKey, user_masterSecret);


        LinkTemplate template = new LinkTemplate();
        template.setAppId(user_appId);
        template.setAppkey(user_appKey);
//        template.set
        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle(title);
        style.setText(text);
        // 配置通知栏图标
//        style.setLogo("icon.png");
        // 配置通知栏网络图标
//        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
//        style.setClearable(true);
        template.setStyle(style);
        template.setUrl("http://www.baidu.com");

        AppMessage message = new AppMessage();
        message.setData(template);
        message.setOffline(true);
        //离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 1000 * 3600);
        //设置推送时间
        message.setPushTime(time);
        //推送给App的目标用户需要满足的条件
        AppConditions cdt = new AppConditions();
        List<String> appIdList = new ArrayList<String>();
        appIdList.add(user_appId);
        message.setAppIdList(appIdList);
        //手机类型
        List<String> phoneTypeList = new ArrayList<String>();
        //省份
        List<String> provinceList = new ArrayList<String>();
        //自定义tag
        List<String> tagList = new ArrayList<String>();
        cdt.addCondition(AppConditions.PHONE_TYPE, phoneTypeList);
        cdt.addCondition(AppConditions.REGION, provinceList);
        cdt.addCondition(AppConditions.TAG, tagList);
        message.setConditions(cdt);

        IPushResult ret = push.pushMessageToApp(message, "智能提醒");
        System.out.println(ret.getResponse().toString());
    }

    public static void main(String[] args) {
        IGtPush push = new IGtPush(url, user_appKey, user_masterSecret);

        // 定义"点击链接打开通知模板"，并设置标题、内容、链接
        LinkTemplate template = new LinkTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTitle("您有一条订单反馈");
        template.setText("您的老人身体很健康，一切安好。");
        template.setUrl("http://qfnegx.cn");

        List<String> appIds = new ArrayList();
        appIds.add(appId);


        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);

        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());

    }
}
