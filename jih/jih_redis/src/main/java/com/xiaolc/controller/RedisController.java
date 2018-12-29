package com.xiaolc.controller;

import com.xiaolc.service.RedisDao;
import com.xiaolc.util.Redis;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lc
 * @Date: 2018/12/28 15:45
 */
@RestController
@Api(value = "redis接口", description = "对redis进行操作")
public class RedisController {
    @Autowired
    private RedisDao redisDao;

    @ApiOperation("得到")
    @RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
    @CrossOrigin
    public String get(@PathVariable("key") String key) {
        return redisDao.get(key);
    }

    @ApiOperation("添加")
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    @CrossOrigin
    public void set(@RequestBody Redis redis) {
        redisDao.set(redis.getKey(), redis.getValue());
    }

    @ApiOperation("删除")
    @RequestMapping(value = "/del/{key}", method = RequestMethod.DELETE)
    @CrossOrigin
    public long del(@PathVariable("key") String key) {
        return redisDao.del(key);
    }

    @ApiOperation("到时自动销毁")
    @RequestMapping(value = "/expire", method = RequestMethod.POST)
    @CrossOrigin
    public void expire(@RequestBody Redis redis) {
        redisDao.expire(redis.getKey(), redis.getSeconds());
    }

    @ApiOperation("判断key是否存在")
    @RequestMapping(value = "/exists/{key}", method = RequestMethod.GET)
    @CrossOrigin
    public Boolean exists(@PathVariable("key") String key) {
        return redisDao.exists(key);
    }
}
