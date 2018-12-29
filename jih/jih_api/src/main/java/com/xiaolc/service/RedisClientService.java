package com.xiaolc.service;

import com.xiaolc.util.Redis;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "JIH-REDIS", url = "http://localhost:7010/")
public interface RedisClientService {

    /**
     * 获取值
     *
     * @param Key
     * @return
     */
    @RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
    String get(@PathVariable("key") String Key);

    /**
     * 设置内容
     *
     * @param redis
     * @return
     */
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    void set(@RequestBody Redis redis);

    /**
     * 删除数据
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "/del/{key}", method = RequestMethod.DELETE)
    long del(@PathVariable("key") String key);

    /**
     * 到时自动销毁
     */
    @RequestMapping(value = "/expire", method = RequestMethod.POST)
    void expire(@RequestBody Redis redis);

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    @RequestMapping(value = "/exists/{key}", method = RequestMethod.GET)
    Boolean exists(@PathVariable("key") String key);
}
