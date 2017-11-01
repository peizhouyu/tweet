package cn.mrpei.tweetadmin.service;

import cn.mrpei.tweetadmin.bean.PageBean;
import cn.mrpei.tweetadmin.dto.client.TweetDetailsDto;


/**
 * Date:2017/10/26
 * Time:15:06
 *
 * @author 裴周宇
 */
public interface TweetService {

    /**
     * Find all tweet page bean.
     *
     * @param currentPage the current page
     * @param pageSize    the page size
     * @return the page bean
     */
    PageBean<TweetDetailsDto> findAllTweet(int currentPage, int pageSize);

    /**
     * Find one tweet by id tweet details dto.
     *
     * @param id the id
     * @return the tweet details dto
     */
    TweetDetailsDto findOneTweetById(Long id);

    /**
     * Delete one tweet by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteOneTweetById(Long id);

    /**
     * Disable one tweet by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean disableOneTweetById(Long id);

    /**
     * Search tweet by title or info page bean.
     *
     * @param condition the condition
     * @return the page bean
     */
    PageBean<TweetDetailsDto> searchTweetByTitleOrInfo(String condition, int currentPage, int pageSize);


    /**
     * Update tweet status boolean.
     *
     * @param tweetDetailsDto the tweet details dto
     * @return the boolean
     */
    boolean updateTweetStatus(TweetDetailsDto tweetDetailsDto);
}
