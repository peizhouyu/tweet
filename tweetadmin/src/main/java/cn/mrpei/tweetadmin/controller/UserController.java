package cn.mrpei.tweetadmin.controller;

import cn.mrpei.tweetadmin.bean.User;
import cn.mrpei.tweetadmin.dto.RoleDto;
import cn.mrpei.tweetadmin.dto.UserDto;
import cn.mrpei.tweetadmin.service.RoleSrevice;
import cn.mrpei.tweetadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/9/27
 * Time:16:35
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleSrevice roleSrevice;


    @GetMapping("/getAllUser")
    private String getAllUser(Model model){
        List<UserDto> userDtoList = userService.getAllUser();
        model.addAttribute("userDtoList",userDtoList);
        //System.out.println(userDtoList.get(1).toString());
        return "User/index";
    }

   @RequestMapping("/addUser")
    public String addUser(UserDto userDto, Model model){
        if (userDto.getHasAdd() == null){
            List<RoleDto> roleDtoList = roleSrevice.getAvailableRoleList();
            model.addAttribute("roleDtoList", roleDtoList);
            return "User/add";
        }else {
            if (userService.saveUser(userDto)){
                model.addAttribute("info","success");
                return "redirect:getAllUser";
            }else {
                model.addAttribute("info","error");
                return "redirect:addUser";
            }
        }
    }

    @RequestMapping(value = "/userUpdate")
    public String userUpdate(UserDto userDto, Model model){
        if (userDto.getHasUpdate() == null){
            UserDto userDtoTem = userService.getOneUserById(userDto.getUserid());
            List<RoleDto> roleDtoList = roleSrevice.getAvailableRoleList();
            model.addAttribute("roleDtoList", roleDtoList);
            model.addAttribute("user",userDtoTem);
            return "User/edit";
        }else {
            if (userService.updateUser(userDto)){
                model.addAttribute("info","success");
                return "redirect:getAllUser";
            }else {
                model.addAttribute("info","error");
                return "redirect:getAllUser";
            }
        }
    }



}
