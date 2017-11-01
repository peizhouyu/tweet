package cn.mrpei.service.impl;

import cn.mrpei.bean.Page;
import cn.mrpei.bean.TweetDetails;
import cn.mrpei.dao.TweetDetailsDao;
import cn.mrpei.dto.TweetDetailsDto;
import cn.mrpei.dto.TweetDetailsListDto;
import cn.mrpei.service.TweetDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TweetDetailsServiceImpl implements TweetDetailsService {

    @Autowired
    private TweetDetailsDao tweetDetailsDao;

    @Value("${uploadContentImg.url}")
    private String contentImgSavePath;


    public String saveContentImg(String fileName) {
        String filePath = contentImgSavePath + "/"+ fileName;
        return filePath;
    }

    public TweetDetailsListDto searchByPage(Page page) {
        TweetDetailsListDto result = new TweetDetailsListDto();
        TweetDetails tweetDetails = new TweetDetails();
        page.setCurrentPage(page.getCurrentPage() + 1);
        tweetDetails.setPage(page);
        List<TweetDetails> list = tweetDetailsDao.selectByPage(tweetDetails);
        List<TweetDetailsDto> data = new ArrayList<TweetDetailsDto>();
        result.setData(data);
        for (TweetDetails tweetDetails1Temp : list){
            TweetDetailsDto tweetDetailsDto = new TweetDetailsDto();
            data.add(tweetDetailsDto);
            BeanUtils.copyProperties(tweetDetails1Temp, tweetDetailsDto);
        }
        result.setHasMore(page.getCurrentPage() < page.getTotalNumber());
        return result;
    }

    public TweetDetailsDto getById(Long id) {
        TweetDetailsDto result = new TweetDetailsDto();
        TweetDetails tweetDetails = tweetDetailsDao.selectById(id);
        BeanUtils.copyProperties(tweetDetails, result);
        return result;
    }


    public boolean saveTweetByOne(TweetDetailsDto tweetDetailsDto) {
        TweetDetails tweetDetails = new TweetDetails();
        BeanUtils.copyProperties(tweetDetailsDto, tweetDetails);
        int result = tweetDetailsDao.insertByOne(tweetDetails);
        return result == 1 ? true:false;
    }

    public boolean deleteTweetByOne(TweetDetailsDto tweetDetailsDto) {
        TweetDetails tweetDetails = new TweetDetails();
        BeanUtils.copyProperties(tweetDetailsDto, tweetDetails);
        int result = tweetDetailsDao.deleteByOne(tweetDetails);
        return result == 1 ? true:false;
    }



}
