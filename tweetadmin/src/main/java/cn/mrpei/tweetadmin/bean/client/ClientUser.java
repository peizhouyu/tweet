package cn.mrpei.tweetadmin.bean.client;

import cn.mrpei.tweetadmin.bean.common.BaseBean;

import java.util.Date;

/**
 * Create by 裴周宇
 * Date:2017/10/11
 * Time:11:00
 */
public class ClientUser extends BaseBean {
    private Long id;
    private String account;
    private String password;
    private String headImgUrl;
    private String phone;
    private String email;
    private String realName;
    private String ip;
    private String userLocation;
    private String lastIp;
    private Integer isDel;
    private Integer isVip;
    private String createTime;

    @Override
    public String toString() {
        return "ClientUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", realName='" + realName + '\'' +
                ", ip='" + ip + '\'' +
                ", userLocation='" + userLocation + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", isDel=" + isDel +
                ", isVip=" + isVip +
                ", createTime=" + createTime +
                '}';
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realnName) {
        this.realName = realnName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
