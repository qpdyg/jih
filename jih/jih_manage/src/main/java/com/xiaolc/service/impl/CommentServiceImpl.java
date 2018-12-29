package com.xiaolc.service.impl;

import com.xiaolc.mapper.CommentMapper;
import com.xiaolc.model.Comment;
import com.xiaolc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lc
 * @Date: 2018/11/28 14:58
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper mapper;

    @Override
    public List<Comment> fandBycid(String cid) {
        return mapper.fandBycid(cid);
    }

    @Override
    public int save(Comment comment) {
        return mapper.save(comment);
    }

    @Override
    public int update(Comment comment) {
        return mapper.update(comment);
    }

    @Override
    public int delete(String mid) {
        return mapper.delete(mid);
    }
}
