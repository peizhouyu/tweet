package cn.mrpei.dto;

import cn.mrpei.bean.Comment;

public class CommentDto extends Comment {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
