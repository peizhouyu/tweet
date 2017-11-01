package cn.mrpei.dto;

import cn.mrpei.bean.TweetDetails;

public class TweetDetailsDto extends TweetDetails {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
