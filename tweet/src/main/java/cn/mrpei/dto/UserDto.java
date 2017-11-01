package cn.mrpei.dto;

import cn.mrpei.bean.User;

public class UserDto extends User {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
