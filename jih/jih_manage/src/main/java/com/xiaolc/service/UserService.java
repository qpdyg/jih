package com.xiaolc.service;

import com.xiaolc.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author lc
 * @Date: 2018/11/27 10:22
 */
@Repository
public interface UserService {
    //用户登陆接口
    Users login(Users users);

    //用户注册接口
    int add(Users users);

    //用户更新接口
    int update(Users users);

    //用户删除接口
    int delete(String id);

    //查询所有用户
    List<Users> list();
}
