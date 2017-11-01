package cn.mrpei.controller.api;

import cn.mrpei.constant.ApiCodeEnum;
import cn.mrpei.constant.ConstantString;
import cn.mrpei.constant.MessageService;
import cn.mrpei.dto.ApiCodeDto;
import cn.mrpei.dto.UserDto;
import cn.mrpei.service.UserService;
import cn.mrpei.utils.CommonUtil;
import cn.mrpei.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 裴周宇 on 2017/9/15.
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {

    @Autowired
    private UserService userService;


    //头像上传绝对路径 来自配置文件
    @Value("${uploadHeadImg.absoluteUrl}")
    private String headImgRootPath;

    //测试方法
    @RequestMapping("/info")
    public String getInfo(){
        return ConstantString.TEST_INFO;
    }

    /**
     * Register api code dto.
     *用户注册
     * @param userDto the user dto
     * @return the api code dto
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiCodeDto register(UserDto userDto){
        ApiCodeDto dto = null;
        String accountTemp = userDto.getAccount().trim();
        userDto.setAccount(accountTemp);
        MessageService messageService = userService.registerUser(userDto);
        if (messageService.getCode() == 200){
            dto = new ApiCodeDto(ApiCodeEnum.REGISTER_SUCCESS);
        }else if (messageService.getCode() == 400){
            dto = new ApiCodeDto(ApiCodeEnum.REGISTER_FAIL);
        }else if (messageService.getCode() == 401){
            dto = new ApiCodeDto(ApiCodeEnum.REGISTER_USER_EXIST);
        }
        return dto;
    }

    /**
     * Update user info api code dto.
     *  TODO 更新用户个人信息 email 真实姓名 ip last_ip  需要进一步实现
     * @param userDto the user dto
     * @return the api code dto
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ApiCodeDto updateUserInfo(UserDto userDto){
        ApiCodeDto dto = null;
        return dto;
    }

    /**
     * Upload head img api code dto.
     *用户头像上传
     * @param file    the file
     *
     * @return the api code dto
     */
    @RequestMapping(value = "/uploadHeadImg", method = RequestMethod.POST)
    public ApiCodeDto uploadHeadImg(@RequestParam(value = "file", required = false) MultipartFile file, UserDto userDto){
        ApiCodeDto dto;
        //实现文件上传
        String fileName = FileUtil.uploadFile(file,  headImgRootPath);
        //文件路径写入数据库
        //TODO 实际上传参数为token 需要将token转换为用户名
        String account = userService.getNameByToken(userDto.getToken());
        userDto.setAccount(account);
        String filePath = userService.saveHeadImg(userDto, fileName);
        dto = new ApiCodeDto(200, filePath);
        return dto;
    }


    /**
     * Login by pwd api code dto.
     *使用用户名和密码登录
     * @param userDto the user dto
     * @return the api code dto
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiCodeDto loginByPwd(UserDto userDto){
        ApiCodeDto dto;
        if (userService.checkByPwd(userDto)){
            //生产一个32为token 并返回给客户端
            String token = CommonUtil.getUUID();
            //保存生成的token到缓存队列
            userService.saveTokenByName(token, userDto.getAccount());
            dto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
            dto.setToken(token);
        }else {
            dto = new ApiCodeDto(ApiCodeEnum.USER_NOT_EXISTS);
        }
        return dto;
    }

    /**
     * Sms api code dto.
     *手机号短信验证码登陆
     * @param phone the phone
     * @return the api code dto
     */
    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    public ApiCodeDto sms(@RequestParam("phone") String phone){
        ApiCodeDto dto;
        //验证是否已经注册
        if (userService.exists(phone)){
            //生成随机数
            String code = String.valueOf(CommonUtil.random(6));
            //保存手机号与对应的md5(6位随机数)（一般保存1分钟，1分钟后失效）
            if (userService.saveCode(phone, code)){
                //调用短信通道，将明文6位随机数发送到对应的手机上。
                if (userService.sendCode(phone, code)) {
                    dto = new ApiCodeDto(ApiCodeEnum.SUCCESS.getErrno(), code);
                }else {
                    dto = new ApiCodeDto(ApiCodeEnum.SEND_FAIL);
                }
            }else {
                dto = new ApiCodeDto(ApiCodeEnum.REPEAT_REQUEST);
            }
        }else {
            dto = new ApiCodeDto(ApiCodeEnum.USER_NOT_EXISTS);
        }
        return dto;
    }



}
