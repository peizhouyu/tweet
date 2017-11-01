package cn.mrpei.service;

import cn.mrpei.bean.Page;
import cn.mrpei.dto.CommentDto;
import cn.mrpei.dto.CommentListDto;
import cn.mrpei.dto.TweetDetailsDto;

import java.util.List;

/**
 * The interface Comment service.
 */
public interface CommentService {

    /**
     * Gets comment by tweet id.
     *  根据内容id获取评论列表
     * @param tweetId the tweet id
     * @param page    the page
     * @return the comment by tweet id
     */
    CommentListDto getCommentByTweetId(Long tweetId, Page page);

    /**
     * Save comment by one boolean.
     * 保存单个评论
     *
     * @param commentDto the comment dto
     * @return the boolean
     */
    boolean saveCommentByOne(CommentDto commentDto);


    /**
     * Delete comment by one boolean.
     * 根据id 删除单个评论
     *
     * @param commentDto the comment dto
     * @return the boolean
     */
    boolean deleteCommentByOne(CommentDto commentDto);
}
