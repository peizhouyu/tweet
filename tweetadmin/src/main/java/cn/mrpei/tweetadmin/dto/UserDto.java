package cn.mrpei.tweetadmin.dto;

import cn.mrpei.tweetadmin.bean.User;

/**
 * Create by 裴周宇
 * Date:2017/9/27
 * Time:16:42
 */
public class UserDto extends User {
    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    private String showTime;

    private String hasAdd;

    private String hasUpdate;

    public String getHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(String hasUpdate) {
        this.hasUpdate = hasUpdate;
    }

    public String getHasAdd() {
        return hasAdd;
    }

    public void setHasAdd(String hasAdd) {
        this.hasAdd = hasAdd;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
