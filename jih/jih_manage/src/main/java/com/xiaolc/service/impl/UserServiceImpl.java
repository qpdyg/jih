package com.xiaolc.service.impl;

import com.xiaolc.mapper.UsersMapper;
import com.xiaolc.model.Users;
import com.xiaolc.service.UserService;
import com.xiaolc.service.UsersClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lc
 * @Date: 2018/11/27 10:23
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(Users users) {
        return usersMapper.queryByName(users);
    }

    @Override
    public int add(Users users) {
        return usersMapper.save(users);
    }

    @Override
    public int update(Users users) {
        //UUID.randomUUID();
        return usersMapper.update(users);
    }

    @Override
    public int delete(String id) {
        return usersMapper.delete(id);
    }

    @Override
    public List<Users> list() {
        return usersMapper.fandAll();
    }
}
