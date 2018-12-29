package com.xiaolc.service.impl;

import com.xiaolc.service.RedisDao;
import com.xiaolc.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lc
 * @Date: 2018/12/29 13:42
 */
@Service
public class RedisDaoimpl implements RedisDao {
    @Autowired
    private RedisClient redisClient;

    @Override
    public String get(String Key) {
        return redisClient.get(Key);
    }

    @Override
    public void set(String key, Object value) {
        redisClient.set(key, value);
    }

    @Override
    public long del(String key) {
        return redisClient.del(key);
    }

    @Override
    public void expire(String key, int seconds) {
        redisClient.expire(key, seconds);
    }

    @Override
    public Boolean exists(String key) {
        return redisClient.exists(key);
    }
}
