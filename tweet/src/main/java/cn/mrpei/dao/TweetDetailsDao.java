package cn.mrpei.dao;

import cn.mrpei.bean.TweetDetails;
import cn.mrpei.dto.TweetDetailsDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetDetailsDao {
    List<TweetDetails> selectByPage(TweetDetails tweetDetails);
    TweetDetails selectById(Long id);

    int insertByOne(TweetDetails tweetDetails);

    int deleteByOne(TweetDetails tweetDetails);
}
