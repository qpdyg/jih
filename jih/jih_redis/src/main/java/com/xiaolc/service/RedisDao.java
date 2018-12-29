package com.xiaolc.service;

public interface RedisDao {
    /**
     * 获取值
     *
     * @param Key
     * @return
     */
    String get(String Key);

    /**
     * 设置内容
     *
     * @param key
     * @param value
     * @return
     */
    void set(String key, Object value);

    /**
     * 删除数据
     *
     * @param key
     * @return
     */
    long del(String key);

    /**
     * 到时自动销毁
     *
     * @param key
     * @param seconds 秒
     */
    void expire(String key, int seconds);

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    Boolean exists(String key);
}
