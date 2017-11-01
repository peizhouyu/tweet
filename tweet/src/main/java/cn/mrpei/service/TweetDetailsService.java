package cn.mrpei.service;

import cn.mrpei.bean.Page;
import cn.mrpei.dto.TweetDetailsDto;
import cn.mrpei.dto.TweetDetailsListDto;

import java.util.List;

/**
 * The interface Tweet details service.
 */
public interface TweetDetailsService {

    /**
     * Save content img string.
     *
     * @param fileName the file name
     * @return the string
     */
    String saveContentImg(String fileName);

    /**
     * Search by page list.
     *  获取内容列表
     *
     * @param page    the page
     * @return the list
     */
    TweetDetailsListDto searchByPage(Page page);

    /**
     * Gets by id.
     * 根据ID获取单个内容详情
     *
     * @param id the id
     * @return the by id
     */
    TweetDetailsDto getById(Long id);

    /**
     * Save tweet by one boolean.
     * 保存单个内容
     *
     * @param tweetDetailsDto the tweet details dto
     * @return the boolean
     */
    boolean saveTweetByOne(TweetDetailsDto tweetDetailsDto);

    /**
     * Delete tweet by one boolean.
     * 根据ID 删除单个内容
     *
     * @param tweetDetailsDto the tweet details dto
     * @return the boolean
     */
    boolean deleteTweetByOne(TweetDetailsDto tweetDetailsDto);
}
