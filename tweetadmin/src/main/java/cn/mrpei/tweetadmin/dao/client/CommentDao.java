package cn.mrpei.tweetadmin.dao.client;

import cn.mrpei.tweetadmin.bean.client.Comment;

import java.util.List;

/**
 * Date:2017/10/30
 * Time:10:36
 *
 * @author 裴周宇
 */
public interface CommentDao {
    List<Comment> selectAllComment();
    Comment selectOneTweetById(Long id);
    List<Comment> selectTweetBySearch(String condition);

    int countTweetBySearch(String condition);
    int countComment();

    int updateCommentStatusById(Comment comment);
    int deleteCommentById(Long id);
}
