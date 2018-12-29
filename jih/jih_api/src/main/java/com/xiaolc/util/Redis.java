package com.xiaolc.util;

import lombok.Data;

/**
 * @author lc
 * @Date: 2018/12/29 14:27
 */
@Data
public class Redis {

    private String key;

    private Object value;

    private Integer seconds;
}
