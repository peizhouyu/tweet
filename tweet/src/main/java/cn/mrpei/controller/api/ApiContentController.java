package cn.mrpei.controller.api;

import cn.mrpei.bean.Page;
import cn.mrpei.constant.ApiCodeEnum;
import cn.mrpei.dto.*;
import cn.mrpei.service.CommentService;
import cn.mrpei.service.TweetDetailsService;
import cn.mrpei.service.UserService;
import cn.mrpei.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * The type Content controller.
 */
@RestController
@RequestMapping("/api/content")
public class ApiContentController {

    @Autowired
    private TweetDetailsService tweetDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Value("${uploadContentImg.absoluteUrl}")
    private String contentImgRootPath;

    /**
     * Get tweet list tweet details list dto.
     * 获取全部吐槽内容列表
     *  TODO 生产环境必须开启token验证 此处为测试方便未作token验证
     * @param page the page
     * @return the list
     */
    @RequestMapping(value = "/tweet/{currentPage}", method = RequestMethod.GET)
    public TweetDetailsListDto getTweetList(Page page){
        return tweetDetailsService.searchByPage(page);
    }

    /**
     * Gets tweet by id.
     *根据id获取单个内容的详细信息
     * @param id the id
     * @return the tweet by id
     */
    @RequestMapping(value = "/tweetById/{id}", method = RequestMethod.GET)
    public TweetDetailsDto getTweetById(@PathVariable("id") Long id){
        return tweetDetailsService.getById(id);
    }

    /**
     * Get comment list list.
     *  根据当前内容id 获取与当前内容关联的评论列表
     * @param tweetId the tweet id
     * @param page    the page
     * @return the list
     */
    @RequestMapping(value = "/getCommentList/{currentPage}/{tweetId}", method = RequestMethod.GET)
    public CommentListDto getCommentList(@PathVariable("tweetId") Long tweetId, Page page){
        return commentService.getCommentByTweetId(tweetId, page);
    }

    /**
     * Submit comment api code dto.
     * 提交评论
     * @param commentDto the comment dto
     * @return the api code dto
     */
    @RequestMapping(value = "/submitComment", method = RequestMethod.POST)
    public ApiCodeDto submitComment(CommentDto commentDto){
        ApiCodeDto dto;
        //根据token获取用户名
        String account = userService.getNameByToken(commentDto.getToken());
        commentDto.setUserAccount(account);
        if (commentService.saveCommentByOne(commentDto)){
            dto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
        }else {
            dto = new ApiCodeDto(ApiCodeEnum.FAIL);
        }
        return dto;
    }


    /**
     * Delete comment api code dto.
     *  删除单个评论
     * @param commentDto the comment dto
     * @return the api code dto
     */
    @RequestMapping(value = "/deleteComment")
    public ApiCodeDto deleteComment(CommentDto commentDto){
        ApiCodeDto dto;
        if (commentService.deleteCommentByOne(commentDto)){
            dto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
        }else {
            dto = new ApiCodeDto(ApiCodeEnum.FAIL);
        }
        return dto;
    }


    /**
     * Submit tweet api code dto.
     *  发布单个内容
     * @param tweetDetailsDto the tweet details dto
     * @return the api code dto
     */
    @RequestMapping(value = "/submitTweet", method = RequestMethod.POST)
    public ApiCodeDto submitTweet(TweetDetailsDto tweetDetailsDto){
        ApiCodeDto dto;
        if (tweetDetailsDto.getToken() != null){
            //根据token获取用户名
            String account = userService.getNameByToken(tweetDetailsDto.getToken());
            Long id = userService.getUserIdByAccount(account);
            tweetDetailsDto.setUserId(id);
            tweetDetailsDto.setUserAccount(account);
            if (tweetDetailsService.saveTweetByOne(tweetDetailsDto)){
                dto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
            }else {
                dto = new ApiCodeDto(ApiCodeEnum.FAIL);
            }
        }else {
            dto = new ApiCodeDto(ApiCodeEnum.TOKEN_NULL);
        }


        return dto;
    }

    /**
     * Upload content img api code dto.
     *  上传吐槽内容图片 返回HTTP 请求地址
     * @param file            the file
     * @return the api code dto
     */
    @RequestMapping(value = "/uploadContentImg", method = RequestMethod.POST)
    public ApiCodeDto uploadContentImg(@RequestParam(value = "file", required = false) MultipartFile file){
        ApiCodeDto dto;
        //实现文件上传
        String fileName = FileUtil.uploadFile(file,  contentImgRootPath);
        //保存文件 并返回http路径
        dto = new ApiCodeDto(200,fileName);
        return dto;
    }

    /**
     * Delete tweet api code dto.
     *根据ID 删除单个内容
     * @param tweetDetailsDto the tweet details dto
     * @return the api code dto
     */
    @RequestMapping(value = "/deleteTweet")
    public ApiCodeDto deleteTweet(TweetDetailsDto tweetDetailsDto){
        ApiCodeDto dto;
        if (tweetDetailsService.deleteTweetByOne(tweetDetailsDto)){
            dto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
        }else {
            dto = new ApiCodeDto(ApiCodeEnum.FAIL);
        }
        return dto;
    }





}
