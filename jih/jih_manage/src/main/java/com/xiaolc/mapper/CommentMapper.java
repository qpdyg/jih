package com.xiaolc.mapper;

import java.util.List;

import com.xiaolc.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {

    //根据内容id查询评论
    List<Comment> fandBycid(@Param("cid") String cid);

    //添加评论
    int save(Comment comment);

    //更新评论
    int update(Comment comment);

    //删除评论
    int delete(@Param("mid") String mid);
}