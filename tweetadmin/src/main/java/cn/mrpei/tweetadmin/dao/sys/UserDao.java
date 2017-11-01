package cn.mrpei.tweetadmin.dao.sys;

import cn.mrpei.tweetadmin.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/9/27
 * Time:15:41
 */

@Mapper
@Repository
public interface UserDao {


    List<User> findByName(User user);
    List<User> findAllUser();
    int insertUserByOne(User user);
    User findUserById(Integer id);
    int updateUser(User user);

    User findByUserName(String username);

    int updateLoginTime(User user);

}
