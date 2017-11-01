package cn.mrpei.tweetadmin.constant;

/**
 * Date:2017/10/28
 * Time:11:21
 *
 * @author 裴周宇
 */
public enum ApiCodeEnum {
    SUCCESS(200,"ok"),
    FAIL(400,"fail");



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
