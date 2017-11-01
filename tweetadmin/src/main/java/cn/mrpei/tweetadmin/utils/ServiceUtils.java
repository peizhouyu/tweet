package cn.mrpei.tweetadmin.utils;

import cn.mrpei.tweetadmin.bean.client.TweetDetails;


/**
 * Date:2017/10/27
 * Time:10:19
 *
 * @author 裴周宇
 */
public class ServiceUtils {

    //对content内容进行截取防止 列表数量过大
    public static TweetDetails subTweetContent(TweetDetails tweetDetails){
        String content = tweetDetails.getContent();
        String contentNow;
        //判断content 内容 长度
        if (content == null || content.length() < 15){
            contentNow = content;
        }else{
            contentNow = content.substring(0, 15) + "......";
        }
        tweetDetails.setContent(contentNow);
        return tweetDetails;
    }

}
