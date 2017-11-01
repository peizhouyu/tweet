package cn.mrpei.tweetadmin.controller;

import cn.mrpei.tweetadmin.bean.User;
import cn.mrpei.tweetadmin.dto.UserDto;
import cn.mrpei.tweetadmin.service.UserService;
import cn.mrpei.tweetadmin.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/9/27
 * Time:15:25
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        //获取security上下文对象
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        UserDto userDto = new UserDto();
        // 登录名
        userDto.setUsername(securityContextImpl.getAuthentication().getName());
        //登录时间
        userDto.setLastLoginTime(CommonUtils.getTimeNow());
        userService.saveLoginTime(userDto);
        model.addAttribute("userDto", userDto);
        return "index";
    }


}
