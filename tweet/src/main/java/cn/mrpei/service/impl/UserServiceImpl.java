package cn.mrpei.service.impl;

import cn.mrpei.bean.User;
import cn.mrpei.cache.CodeCache;
import cn.mrpei.constant.MessageService;
import cn.mrpei.constant.TokenCache;
import cn.mrpei.dao.UserDao;
import cn.mrpei.dto.UserDto;
import cn.mrpei.service.UserService;
import cn.mrpei.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    //面向接口的拼接URL 数据库中存储的路径
    @Value("${uploadHeadImg.url}")
    private String headImgSavePath;

    private final static Logger logger = LoggerFactory
            .getLogger(UserService.class);


    public String saveHeadImg(UserDto userDto, String fileName) {
        String filePath = headImgSavePath + "/"+ fileName;
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setHeadImgUrl(filePath);
        userDao.updateUserHeadImg(user);
        return filePath;
    }



    public MessageService registerUser(UserDto userDto) {
        MessageService messageService;
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        //判断用户名是否已经被注册
        System.out.println(user.getAccount());
        List<User> list = userDao.selectUserByName(user);
        if (list != null && list.size() == 1){
            //该用户名已经在数据库中存在
            messageService = new MessageService(401, "该用户名已被注册");
            return messageService;
        }else {
            user.setCreateTime(new Date());
            //默认账号不被弃用
            user.setIsDel(0);
            //默认不是会员
            user.setIsVip(0);
            int result = userDao.insertUser(user);
            if (result == 1){
                messageService = new MessageService(200, "注册成功");
                return messageService;
            }else {
                messageService = new MessageService(400, "数据库异常");
                return messageService;
            }
        }

    }

    public boolean checkByPwd(UserDto userDto) {
        User user = new User();
        user.setAccount(userDto.getAccount());
        user.setPassword(userDto.getPassword());
        List<User> list = userDao.selectUser(user);
        return list != null && list.size() == 1;
    }

    public boolean exists(String phone) {
        User user = new User();
        user.setPhone(phone);
        List<User> list = userDao.selectUserByPhone(user);
        return list != null && list.size() == 1;
    }

    public boolean saveCode(String phone, String code) {
        //TODO 生产环境需要使用非关系型缓存队列以提高性能
        CodeCache codeCache = CodeCache.getInstance();
        //TODO 生产环境开启MD5加密 code
        //return codeCache.save(phone, MD5Util.getMD5(code));
        return codeCache.save(phone, code);
    }


    public boolean sendCode(String phone, String content) {
        logger.info(phone + "|" + content);
        return true;
    }


    public void saveTokenByName(String token, String name) {
        TokenCache tokenCache = TokenCache.getInstance();
        tokenCache.saveTokenByName(token, name);
    }

    public String getNameByToken(String token) {
        TokenCache tokenCache = TokenCache.getInstance();
        return tokenCache.getName(token);
    }

    public void saveTokenByPhone(String token, String phone) {
        TokenCache tokenCache = TokenCache.getInstance();
        tokenCache.saveTokenByPhone(token, phone);
    }

    public String getPhoneByToken(String token) {
        TokenCache tokenCache = TokenCache.getInstance();
        return tokenCache.getPhone(token);
    }

    public Long getUserIdByAccount(String account) {
        return userDao.selectUserIdByAccount(account);
    }
}
