package cn.mrpei.tweetadmin.controller;

import cn.mrpei.tweetadmin.bean.PageBean;
import cn.mrpei.tweetadmin.constant.ApiCodeEnum;
import cn.mrpei.tweetadmin.dto.ApiCodeDto;
import cn.mrpei.tweetadmin.dto.client.ClientUserDto;
import cn.mrpei.tweetadmin.service.ClientUserService;

import cn.mrpei.tweetadmin.utils.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Create by 裴周宇
 * Date:2017/9/27
 * Time:16:37
 * @author 裴周宇
 */
@Controller
@RequestMapping("/clientUser")
public class ClientUserController {

    @Autowired
    private ClientUserService clientUserService;



    @GetMapping("/info")
    @ResponseBody
    public String hello(){
        return "222";
    }

    @GetMapping("/getClientUserList")
    public String getClientUserList(Model model, PageBean pageBean){
        PageBean<ClientUserDto> clientUserDtoList = clientUserService.findAllClientUser(pageBean.getCurrentPage(), pageBean.getPageSize());
        model.addAttribute("clientUserDtoList",clientUserDtoList);
        model.addAttribute("isSearch","0");
        return "Content/client_index";
    }

    @RequestMapping("/updateClientUser")
    public String updateClientUser(Model model, ClientUserDto clientUserDto){
        if (clientUserDto.getHasUpdate() == null){
            clientUserDto = clientUserService.findOneClientUserById(clientUserDto.getClientUserId());
            model.addAttribute("clientUser", clientUserDto);
            return "Content/client_edit";
        }else {
            if (clientUserService.updateClientUser(clientUserDto)){
                model.addAttribute("info","success");
                return "redirect:getClientUserList";
            }else {
                model.addAttribute("info","error");
                return "redirect:getClientUserList";
            }
        }
    }


    @RequestMapping("/searchByName")
    public String searchByName(Model model,PageBean pageBean,ClientUserDto clientUserDto){
        String name;
        if (clientUserDto.getSearchName() != null){
            Cache.SEARCH_CLIENT_USER_NAME = clientUserDto.getSearchName();
            name = clientUserDto.getSearchName();
        }else {
            name = Cache.SEARCH_CLIENT_USER_NAME;
        }

        PageBean<ClientUserDto> clientUserDtoList = clientUserService.searchClientUserByAccountOrRealName(name, pageBean.getCurrentPage(), pageBean.getPageSize());
        model.addAttribute("clientUserDtoList",clientUserDtoList);
        model.addAttribute("isSearch","1");
        return "Content/client_index";
    }

    @RequestMapping("/getClientUserById")
    public String getClientUserById(Model model,@RequestParam("userId") Long userId){
        ClientUserDto clientUserDto = clientUserService.findOneClientUserById(userId);
        model.addAttribute("clientUser", clientUserDto);
        return "Content/client_one";
    }

    @RequestMapping("/deleteClientUser")
    @ResponseBody
    public ApiCodeDto deleteTweetById(ClientUserDto clientUserDto){
        ApiCodeDto dto;
        if (clientUserService.deleteClientUser(clientUserDto.getId())){
            dto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
        }else {
            dto = new ApiCodeDto(ApiCodeEnum.FAIL);
        }
        return dto;
    }


}
