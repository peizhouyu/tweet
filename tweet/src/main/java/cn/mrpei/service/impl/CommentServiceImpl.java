package cn.mrpei.service.impl;

import cn.mrpei.bean.Comment;
import cn.mrpei.bean.Page;
import cn.mrpei.bean.TweetDetails;
import cn.mrpei.dao.CommentDao;
import cn.mrpei.dto.CommentDto;
import cn.mrpei.dto.CommentListDto;
import cn.mrpei.dto.TweetDetailsDto;
import cn.mrpei.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


    public CommentListDto getCommentByTweetId(Long tweetId, Page page) {
        Comment comment = new Comment();
        CommentListDto result = new CommentListDto();
        TweetDetails tweetDetails = new TweetDetails();
        tweetDetails.setId(tweetId);
        // 前端app页码从0开始计算，这里需要+1
        page.setCurrentPage(page.getCurrentPage() + 1);
        // 设置分页条件
        comment.setPage(page);
        List<Comment> list = commentDao.selectListByTweetId(tweetDetails);
       //组织返回值
        List<CommentDto> data = new ArrayList<CommentDto>();
        result.setData(data);
        for (Comment commentTemp : list){
            CommentDto commentDto = new CommentDto();
            data.add(commentDto);
            BeanUtils.copyProperties(commentTemp, commentDto);
        }
        result.setHasMore(page.getCurrentPage() < page.getTotalNumber());
        return result;
    }

    public boolean saveCommentByOne(CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        int result = commentDao.insertByOne(comment);
        return result == 1 ? true : false;
    }

    public boolean deleteCommentByOne(CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        int result = commentDao.deleteByOne(comment);
        return result == 1 ? true : false;
    }
}
