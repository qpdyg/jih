package com.xiaolc;

import com.xiaolc.util.RedisClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author lc
 * @Date: 2018/12/28 14:22
 */
public class test {
    @Test
    public void testJedis() {
        //创建一个Jedis的连接
        Jedis jedis = new Jedis("111.231.231.56", 6379);
        //执行redis命令
        jedis.set("mytest", "hello world, this is jedis client!");
        //从redis中取值
        String result = jedis.get("mytest");
        jedis.del("mytest");
        //打印结果
        System.out.println(result);
        //关闭连接
        jedis.close();
    }
    @Test
    public void testJedisPool() {
        //创建一连接池对象
        JedisPool jedisPool = new JedisPool("111.231.231.56", 6379);
        //从连接池中获得连接
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get("licheng");
        System.out.println(result);
        //关闭连接
        jedis.close();
        //关闭连接池
        jedisPool.close();
    }
}
