package cn.mrpei.tweetadmin.controller;

import cn.mrpei.tweetadmin.dto.RoleDto;
import cn.mrpei.tweetadmin.service.RoleSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/10/3
 * Time:17:12
 */

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleSrevice roleSrevice;

    /**
     * 角色管理
     */

    @GetMapping("/getRoleList")
    public String getRoleList(Model model){
        List<RoleDto> roleDtoList = roleSrevice.getRoleList();
        //System.out.println(roleDtoList.get(1).getRoleName());
        model.addAttribute("roleDtoList", roleDtoList);
        return "Role/index";
    }

    @RequestMapping("/addRole")
    public String addRole(RoleDto roleDto, Model model){
        if (roleDto.getHasAdd() == null){
            return "Role/add";
        }else {
            if (roleSrevice.addRole(roleDto)){
                model.addAttribute("info","success");
               // System.out.println(roleDto.getTitle()+ roleDto.getStatus());
                return "redirect:getRoleList";
            }else {
                model.addAttribute("info","error");
                return "redirect:addRole";
            }
        }
    }



}
