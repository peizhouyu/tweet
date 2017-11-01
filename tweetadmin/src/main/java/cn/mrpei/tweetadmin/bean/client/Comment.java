package cn.mrpei.tweetadmin.bean.client;

import cn.mrpei.tweetadmin.bean.common.BaseBean;

import java.util.Date;

/**
 * Create by 裴周宇
 * Date:2017/10/11
 * Time:11:00
 */
public class Comment extends BaseBean {
    private Long id;
    private String content;
    private Integer starNum;
    private Date createTime;
    private String ip;
    private Integer isDel;
    private Integer isDisable;
    private String userAccount;
    private String userLocation;
    private Long tweetId;
    private Long conmmentId;

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStarNum() {
        return starNum;
    }

    public void setStarNum(Integer starNum) {
        this.starNum = starNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public Long getConmmentId() {
        return conmmentId;
    }

    public void setConmmentId(Long conmmentId) {
        this.conmmentId = conmmentId;
    }
}
