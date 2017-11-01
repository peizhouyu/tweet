package cn.mrpei.constant;

public enum ApiCodeEnum {
    REGISTER_SUCCESS(200,"注册成功！"),
    REGISTER_USER_EXIST(401,"用户已存在！"),
    REGISTER_FAIL(400,"注册失败！"),
    SUCCESS(200,"ok"),
    FAIL(400,"fail"),
    USER_NOT_EXISTS(1,"用户不存在！"),
    REPEAT_REQUEST(2,"验证码有效时间内不需重复请求！"),
    SEND_FAIL(3,"发送验证码失败！请稍后重试！"),
    CODE_INVALID(4,"验证码已失效！请重新请求验证码！"),
    CODE_ERROR(5,"验证码不正确！"),
    BUY_FAIL(6,"提交失败！"),
    NOT_LOGGED(7,"没有登录！"),
    NO_AUTH(8,"没有权限！"),
    TOKEN_NULL(401,"token为空值");


    private Integer errno;
    private String msg;

    ApiCodeEnum(Integer errno, String msg) {
        this.errno = errno;
        this.msg = msg;
    }

    public Integer getErrno() {
        return errno;
    }

    public String getMsg() {
        return msg;
    }
}
