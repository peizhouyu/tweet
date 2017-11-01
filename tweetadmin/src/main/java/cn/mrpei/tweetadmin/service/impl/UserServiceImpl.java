package cn.mrpei.tweetadmin.service.impl;

import cn.mrpei.tweetadmin.bean.User;
import cn.mrpei.tweetadmin.dao.sys.UserDao;
import cn.mrpei.tweetadmin.dto.UserDto;
import cn.mrpei.tweetadmin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/9/27
 * Time:16:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<UserDto> getAllUser() {
        List<User> list = userDao.findAllUser();
        List<UserDto> result = new ArrayList<UserDto>();
        for (User userTemp : list){
            UserDto userDto = new UserDto();
            result.add(userDto);
            //格式化显式的时间
//            Date time = userTemp.getLastLoginTime();
//            SimpleDateFormat formatter;
//            formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
//            String string = formatter.format(time);
//            userDto.setShowTime(string);
            BeanUtils.copyProperties(userTemp, userDto);
        }
        return result;
    }

    @Override
    public boolean saveUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        user.setCreateTime(df.format(new Date()));
        user.setLastLoginTime(df.format(new Date()));
        int result = userDao.insertUserByOne(user);
        return result == 1 ? true : false;
    }

    @Override
    public UserDto getOneUserById(Integer userid) {
        UserDto userDto = new UserDto();
        User user = userDao.findUserById(userid);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        int result = userDao.updateUser(user);
        return result == 1 ? true : false;
    }

    @Override
    public boolean saveLoginTime(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        int result = userDao.updateLoginTime(user);
        return result == 1 ? true : false;
    }


}
