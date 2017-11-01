package cn.mrpei.tweetadmin.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date:2017/10/27
 * Time:16:38
 *
 * @author 裴周宇
 */
public class CommonUtils {
    public static String getTimeNow(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        return df.format(new Date());
    }

    //java msyql datatime 时间 去掉后面的零
    //TODO removeZero() 只为当前实现功能 后期必须改进

    public static String removeZero(String time){
        return time.substring(0,19);
    }
}
