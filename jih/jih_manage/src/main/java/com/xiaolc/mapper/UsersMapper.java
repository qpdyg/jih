package com.xiaolc.mapper;

import com.xiaolc.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper {
    //用户登陆接口
    Users queryByName(Users users);

    //用户注册接口
    int save(Users users);

    //用户更新接口
    int update(Users users);

    //用户删除接口
    int delete(String id);

    //查询所有用户
    List<Users> fandAll();
}