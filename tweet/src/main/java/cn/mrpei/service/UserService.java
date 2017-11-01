package cn.mrpei.service;

import cn.mrpei.constant.MessageService;
import cn.mrpei.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * The interface User service.
 */
public interface UserService {


    /**
     * Save head img string.
     *
     * @param userDto  the user dto
     * @param fileName the file name
     * @return the string
     */
    String saveHeadImg(UserDto userDto, String fileName);


    /**
     * Register user message service.
     *
     * @param userDto the user dto
     * @return the message service
     */
    MessageService registerUser(UserDto userDto);


    /**
     * Check by pwd boolean.
     * 用户名密码登录验证
     *
     * @param userDto the user dto
     * @return the boolean
     */
    boolean checkByPwd(UserDto userDto);

    /**
     * 判断手机号是否存在
     *
     * @param phone 手机号
     * @return true ：存在，false：不存在
     */
    boolean exists(String phone);


    /**
     * 保存手机号与对应的验证码的MD5码到缓存中
     *
     * @param phone 手机号
     * @param code  验证码
     * @return 是否保存成功 ：true：保存成功，false：保存失败
     */
    boolean saveCode(String phone, String code);

    /**
     * 下发短信验证码
     *
     * @param phone   手机号
     * @param content 验证码
     * @return 是否发送成功 ：true：发送成功，false：发送失败
     */
    boolean sendCode(String phone, String content);

    /**
     * Save token by name.
     * 保存token和对应的用户名
     *
     * @param token the token
     * @param name  the name
     */
    void saveTokenByName(String token, String name);

    /**
     * Gets name by token.
     * 获取与token对应的用户名
     *
     * @param token the token
     * @return the name by token
     */
    String getNameByToken(String token);


    /**
     * Save token by name.
     * 保存token和对应的手机号
     *
     * @param token the token
     * @param phone the name
     */
    void saveTokenByPhone(String token, String phone);

    /**
     * Gets name by token.
     * 获取与token对应的用户信息(手机号)
     *
     * @param token the token
     * @return the name by token
     */
    String getPhoneByToken(String token);

    /**
     * Gets user id by name.
     * 根据用户名获取对应的 ID
     * @param account the name
     * @return the user id by name
     */
    Long getUserIdByAccount(String account);


}
