package com.xiaolc.service;

import com.xiaolc.model.Users;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author lc
 * @Date: 2018/12/4 09:42
 */
@FeignClient(value = "JIH-MANAGE", url = "http://localhost:8001/")
public interface UsersClientService {

    //用户登陆接口
    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    Users login(Users users);

    //用户注册接口
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    boolean add(Users users);

    //用户更新接口
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    boolean update(Users users);

    //用户删除接口
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    boolean delete(@PathVariable("id") String id);

    //查询所有用户
    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    List<Users> list();
}
