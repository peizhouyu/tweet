package cn.mrpei.dao;

import cn.mrpei.bean.Comment;
import cn.mrpei.bean.TweetDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    List<Comment> selectListByTweetId(TweetDetails tweetDetails);
    int insertByOne(Comment comment);
    int deleteByOne(Comment comment);
}
