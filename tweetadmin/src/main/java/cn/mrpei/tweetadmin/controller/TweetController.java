package cn.mrpei.tweetadmin.controller;

import cn.mrpei.tweetadmin.bean.PageBean;
import cn.mrpei.tweetadmin.constant.ApiCodeEnum;
import cn.mrpei.tweetadmin.dto.ApiCodeDto;
import cn.mrpei.tweetadmin.dto.client.TweetDetailsDto;
import cn.mrpei.tweetadmin.service.TweetService;
import cn.mrpei.tweetadmin.utils.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Date:2017/10/26
 * Time:16:02
 *
 * @author 裴周宇
 */
@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @RequestMapping("/getTweetList")
    public String getTweetList(Model model, PageBean pageBean){
        PageBean<TweetDetailsDto> tweetDetailsDtoList = tweetService.findAllTweet(pageBean.getCurrentPage(), pageBean.getPageSize());
        model.addAttribute("tweetDetailsDtoList", tweetDetailsDtoList);
        model.addAttribute("isSearch","0");
        return "Content/tweet_index";
    }

    @RequestMapping("/searchByCondition")
    public String searchByCondition(Model model, PageBean pageBean, TweetDetailsDto tweetDetailsDto){
        String condition;
        if (tweetDetailsDto.getSearchCondition() != null){
            Cache.SEARCH_TWEET_NAME = tweetDetailsDto.getSearchCondition();
            condition = tweetDetailsDto.getSearchCondition();
        }else {
            condition = Cache.SEARCH_TWEET_NAME;
        }

        PageBean<TweetDetailsDto> tweetDetailsDtoList  = tweetService.searchTweetByTitleOrInfo(condition, pageBean.getCurrentPage(), pageBean.getPageSize());
        model.addAttribute("tweetDetailsDtoList", tweetDetailsDtoList);
        model.addAttribute("isSearch","1");
        return "Content/tweet_index";
    }

    @RequestMapping("/getOneTweet")
    public String getOneTweet(Model model,TweetDetailsDto tweetDetailsDto){
        TweetDetailsDto tweetDetailsDtoTem = tweetService.findOneTweetById(tweetDetailsDto.getId());
        model.addAttribute("tweet", tweetDetailsDtoTem);
        return "Content/tweet_one";
    }

    @RequestMapping("/updateTweetStatus")
    public String updateTweetStatus(Model model,TweetDetailsDto tweetDetailsDto){
            //TODO 这个方法写的 比较失败 成功的方法 应该当是 简洁 易懂的
            //TODO 之后更新后的页面反馈逻辑 做成 ajax 或者 js 弹出提示信息更合适
        if (tweetDetailsDto.getHasUpdate() == null){
            model.addAttribute("info",tweetDetailsDto.getUpdateInfo());
            tweetDetailsDto = tweetService.findOneTweetById(tweetDetailsDto.getId());
            model.addAttribute("tweetDetailsDto", tweetDetailsDto);
            return "Content/tweet_edit";
        }else {
            String info;
            // 把 hasUpdate 置为空 使递归调用 初始化当前 模板
            tweetDetailsDto.setHasUpdate(null);
            if (tweetService.updateTweetStatus(tweetDetailsDto)){
                info = "success";
            }else {
                info = "fail";
            }
            //模板显示更新后的状态 附带info 信息 反应 更新是否成功 递归调用 /updateTweetStatus
            return "redirect:updateTweetStatus?id="+ tweetDetailsDto.getId()+"&updateInfo="+info;
        }
    }

    @RequestMapping("/deleteTweet")
    @ResponseBody
    public ApiCodeDto deleteTweetById(TweetDetailsDto tweetDetailsDto){
        ApiCodeDto dto;
        if (tweetService.deleteOneTweetById(tweetDetailsDto.getId())){
            dto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
        }else {
            dto = new ApiCodeDto(ApiCodeEnum.FAIL);
        }
        return dto;
    }





}
