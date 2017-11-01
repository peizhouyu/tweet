package cn.mrpei.constant;

/**
 * The type Message service.
 * service层向controller 传递信息的封装类
 */
public class MessageService {
    private String messages;
    private Integer code;
    private String info;

    public MessageService(Integer code) {
        this.code = code;
    }

    public MessageService(Integer code,String messages) {
        this.code = code;
        this.messages = messages;
    }

    public MessageService(String messages, Integer code, String info) {
        this.messages = messages;
        this.code = code;
        this.info = info;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
