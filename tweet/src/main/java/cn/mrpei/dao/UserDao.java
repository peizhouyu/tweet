package cn.mrpei.dao;

import cn.mrpei.bean.User;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> selectUserByPhone(User user);
    List<User> selectUser(User user);
    List<User> selectUserByName(User user);
    int insertUser(User user);
    int updateUserHeadImg(User user);
    Long selectUserIdByAccount(String account);
}
