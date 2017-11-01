package cn.mrpei.tweetadmin.dto;

import cn.mrpei.tweetadmin.constant.ApiCodeEnum;

/**
 * Date:2017/10/28
 * Time:11:26
 *
 * @author 裴周宇
 */
public class ApiCodeDto {
    private Integer errno;
    private String msg;
    private String token;
    private String code;

    public ApiCodeDto() {
    }

    public ApiCodeDto(Integer errno, String msg) {
        this.errno = errno;
        this.msg = msg;
    }

    public ApiCodeDto(ApiCodeEnum apiCodeEnum){
        this.errno = apiCodeEnum.getErrno();
        this.msg = apiCodeEnum.getMsg();
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
