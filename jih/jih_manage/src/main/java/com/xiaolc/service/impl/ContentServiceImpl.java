package com.xiaolc.service.impl;

import com.xiaolc.mapper.ContentMapper;
import com.xiaolc.model.Content;
import com.xiaolc.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author lc
 * @Date: 2018/11/28 10:21
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper mapper;

    @Override
    public List<Content> fandAll() {
        return mapper.fandAll();
    }

    @Override
    public Content findById(String cid) {
        return mapper.findById(cid);
    }

    @Override
    public List<Content> fandName(String cname) {
        return mapper.fandName(cname);
    }

    @Override
    public int save(Content content) {
        content.setCid(UUID.randomUUID().toString());
        return mapper.save(content);
    }

    @Override
    public int update(Content content) {
        return mapper.update(content);
    }

    @Override
    public int delete(String mid) {
        return mapper.delete(mid);
    }
}
