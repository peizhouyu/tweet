package cn.mrpei.tweetadmin.service;

import cn.mrpei.tweetadmin.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/9/27
 * Time:16:41
 */
public interface UserService {


    /**
     * Gets all user.
     * 获取所有管理员信息
     *
     * @return the all user
     */
    List<UserDto> getAllUser();

    /**
     * Save user boolean.
     * 新增管理员
     *
     * @param userDto the user dto
     * @return the boolean
     */
    boolean saveUser(UserDto userDto);

    /**
     * Gets one user by id.
     * 根据id查询 单个user
     *
     * @param userid the userid
     * @return the one user by id
     */
    UserDto getOneUserById(Integer userid);


    /**
     * Update user boolean.
     * 更新
     *
     * @param userDto the user dto
     * @return the boolean
     */
    boolean updateUser(UserDto userDto);

    /**
     * Save login time boolean.
     *
     * @param userDto the user dto
     * @return the boolean
     */
    boolean saveLoginTime(UserDto userDto);
}
