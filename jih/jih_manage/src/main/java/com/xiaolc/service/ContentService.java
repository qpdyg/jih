package com.xiaolc.service;

import com.xiaolc.model.Content;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lc
 * @Date: 2018/11/28 10:21
 */
public interface ContentService {
    //查询所有内容
    List<Content> fandAll();

    //根据cid查内容
    Content findById(String cid);

    //根据名称查询内容
    List<Content> fandName(String cname);

    //添加内容
    int save(Content content);

    //修改内容
    int update(Content content);

    //删除内容
    int delete(@Param("cid") String cid);
}
