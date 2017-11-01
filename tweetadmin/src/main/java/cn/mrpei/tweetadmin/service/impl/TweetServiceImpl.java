package cn.mrpei.tweetadmin.service.impl;

import cn.mrpei.tweetadmin.bean.PageBean;
import cn.mrpei.tweetadmin.bean.client.TweetDetails;
import cn.mrpei.tweetadmin.dao.client.TweetDao;
import cn.mrpei.tweetadmin.dto.client.TweetDetailsDto;
import cn.mrpei.tweetadmin.service.TweetService;
import cn.mrpei.tweetadmin.utils.ServiceUtils;
import cn.mrpei.tweetadmin.utils.StaticClass;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2017/10/26
 * Time:15:29
 *
 * @author 裴周宇
 */
@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetDao tweetDao;

    @Override
    public PageBean<TweetDetailsDto> findAllTweet(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<TweetDetails> list = tweetDao.selectAllTweet();
        List<TweetDetailsDto> result = new ArrayList<>();
        for (TweetDetails tweetDetailsTmpl : list){
            //对content内容进行截取防止 列表数量过大
            TweetDetailsDto tweetDetailsDto = new TweetDetailsDto();
            result.add(tweetDetailsDto);
            BeanUtils.copyProperties(ServiceUtils.subTweetContent(tweetDetailsTmpl), tweetDetailsDto);
        }
        int countNum = tweetDao.countTweet();
        PageBean<TweetDetailsDto> pageData = new PageBean<>(currentPage, pageSize, countNum);
        pageData.setItems(result);
        return pageData;
    }

    @Override
    public TweetDetailsDto findOneTweetById(Long id) {
        TweetDetailsDto tweetDetailsDto = new TweetDetailsDto();
        TweetDetails tweetDetails = tweetDao.selectOneTweetById(id);
        BeanUtils.copyProperties(tweetDetails, tweetDetailsDto);
        return tweetDetailsDto;
    }

    @Override
    public boolean deleteOneTweetById(Long id) {
        int result = tweetDao.deleteTweetById(id);
        return result == 1 ? true : false;
    }

    @Override
    public boolean disableOneTweetById(Long id) {
        return false;
    }

    @Override
    public PageBean<TweetDetailsDto> searchTweetByTitleOrInfo(String condition,int currentPage, int pageSize) {
        int countNum = tweetDao.countTweetBySearch(condition);
        List<TweetDetails> list;
        String searchInfo = null;
        if (countNum == 0){
            PageHelper.startPage(currentPage,pageSize);
            list = tweetDao.selectAllTweet();
            countNum = tweetDao.countTweet();
            searchInfo = StaticClass.SEARCH_TWEET_INFO;
        }else {
            PageHelper.startPage(currentPage, pageSize);
            list = tweetDao.selectTweetBySearch(condition);
        }

        List<TweetDetailsDto> result = new ArrayList<>();
        for (TweetDetails tweetDetailsTmpl : list){
            //对content内容进行截取防止 列表数量过大
            TweetDetailsDto tweetDetailsDto = new TweetDetailsDto();
            result.add(tweetDetailsDto);
            BeanUtils.copyProperties(ServiceUtils.subTweetContent(tweetDetailsTmpl), tweetDetailsDto);
        }
        PageBean<TweetDetailsDto> pageData = new PageBean<>(currentPage, pageSize, countNum);
        pageData.setItems(result);
        pageData.setInfo(searchInfo);
        return pageData;
    }

    @Override
    public boolean updateTweetStatus(TweetDetailsDto tweetDetailsDto) {
        TweetDetails tweetDetails = new TweetDetails();
        BeanUtils.copyProperties(tweetDetailsDto, tweetDetails);
        int result = tweetDao.updateTweetStatusById(tweetDetails);
        return result == 1 ? true : false;
    }
}
