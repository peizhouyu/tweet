package cn.mrpei.tweetadmin.dao.client;

import cn.mrpei.tweetadmin.bean.client.TweetDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Date:2017/10/26
 * Time:9:58
 *
 * @author 裴周宇
 */
@Repository
public interface TweetDao {
    List<TweetDetails> selectAllTweet();
    TweetDetails selectOneTweetById(Long id);
    List<TweetDetails> selectTweetBySearch(String condition);

    int countTweetBySearch(String condition);

    int countTweet();

    int updateTweetStatusById(TweetDetails tweetDetails);

    int deleteTweetById(Long id);
}
